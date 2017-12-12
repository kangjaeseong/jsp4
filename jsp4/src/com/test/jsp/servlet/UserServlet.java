package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.test.jsp.dto.UserInfo;
import com.test.jsp.service.UserService;
import com.test.jsp.service.UserServiceImpl;

public class UserServlet extends HttpServlet {

	UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");// 요청
		res.setCharacterEncoding("utf-8");// 응답
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String cmd = req.getParameter("cmd");

		if (cmd == null) {
			res.sendRedirect("/error.jsp");

		} else if (cmd.equals("list")) {
			String html = "";
			ArrayList<HashMap<String, String>> userList = us.getUserList();
			for (HashMap<String, String> map : userList) {
				html += "<tr>";
				Iterator<String> it = map.keySet().iterator();
				while (it.hasNext()) { // 처음으로 들어가 투스 펄스 확인
					String key = it.next();
					html += "<td>" + map.get(key) + "</td>";
				}
				html += "</tr>";
			}
			out.println(html);

		} else if (cmd.equals("login")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			HashMap<String, String> hm = new HashMap<String, String>();
			try {
				UserInfo ui = us.getUser(id, pwd);
				if (ui == null) {
					hm.put("result", "no");
					hm.put("msg", "아이디 와 비밀번호 확인");

				} else {
					HttpSession hs = req.getSession();
					hs.setAttribute("user", ui);
					hm.put("result", "ok");
					hm.put("msg", ui.getUserName() + "님 환영");
				}

				Gson gs = new Gson();
				out.println(gs.toJson(hm));
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} else if (cmd.equals("logout")) {
			HttpSession hs = req.getSession();
			hs.invalidate();
			res.sendRedirect("/user/login.jsp");
		} else {
			res.sendRedirect("/error.jsp");
		}
	}

}
