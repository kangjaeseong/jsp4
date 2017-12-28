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
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String cmd = req.getParameter("cmd");
		System.out.println(req.getRequestURI());
		if (cmd == null) {
			res.sendRedirect("/error.jsp");
		} else if (cmd.equals("list")) {
			ArrayList<UserInfo> userList = us.getUserList();
			Gson gs = new Gson();
			out.println(gs.toJson(userList));
		} else if (cmd.equals("login")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			HashMap<String, String> hm = new HashMap<String, String>();
			try {
				UserInfo ui = us.getUser(id, pwd);
				if (ui == null) {
					hm.put("result", "no");
					hm.put("msg", "아이디와 비밀번호를 확인하세요");
				} else {
					HttpSession hs = req.getSession();
					hs.setAttribute("user", ui);
					hm.put("result", "ok");
					hm.put("msg", ui.getUserName() + "님 환영!!");
				}
				Gson gs = new Gson();
				out.println(gs.toJson(hm));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("logout")) {
			HttpSession hs = req.getSession();
			hs.invalidate();
			res.sendRedirect("/user/login.jsp");
		} else if (cmd.equals("join")) {
			String params = req.getParameter("params");
			Gson gs = new Gson();
			UserInfo ui = gs.fromJson(params, UserInfo.class);
			int result = us.insertUser(ui);
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("result", "no");
			hm.put("msg", "회원가입에 실패하셨습니다.");
			if (result != 0) {
				hm.put("result", "ok");
				hm.put("msg", "회원가입에 성공하셨습니다.");
				hm.put("url", "/user/login.jsp");
			}
			out.println(gs.toJson(hm));
		} else if (cmd.equals("view")) {
			int userNo = Integer.parseInt(req.getParameter("userno"));
			UserInfo ui = us.getUser(userNo);
			Gson gs = new Gson();
			out.println(gs.toJson(ui));
		} else if (cmd.equals("delete")) {
			String checkPwd = req.getParameter("checkPwd");
			UserInfo ui = (UserInfo) req.getSession().getAttribute("user");
			ui.setUserPwd(checkPwd);
			int result = us.deleteUser(ui);
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("result", "no");
			hm.put("msg", "회원 탈퇴에 실패하셨습니다.");
			if (result != 0) {
				hm.put("result", "ok");
				hm.put("msg", "회원탈퇴에 성공하셨습니다.");
				hm.put("url", "/user/logout.user?cmd=logout");
			}
			Gson gs = new Gson();
			out.println(gs.toJson(hm));
		} else if (cmd.equals("update")) {
			String params = req.getParameter("params");
			Gson gs = new Gson();
			UserInfo ui = gs.fromJson(params, UserInfo.class);
			HttpSession hs = req.getSession();
			UserInfo sui = (UserInfo) hs.getAttribute("user");
			ui.setUserNo(sui.getUserNo());
			int result = us.updateUser(ui);
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("result", "no");
			hm.put("msg", "회원 수정이 실패하셨습니다.");
			if (result != 0) {
				hm.put("result", "ok");
				hm.put("msg", "회원 수정이 성공하셨습니다.");
				hm.put("url", "/user/view.jsp?userno=" + ui.getUserNo());
			}
			out.println(gs.toJson(hm));
		} else if (cmd.equals("checkPwd")) {
			String checkPwd = req.getParameter("checkPwd");
			HttpSession hs = req.getSession();
			UserInfo ui = (UserInfo) hs.getAttribute("user");
			String userPwd = ui.getUserPwd();
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("result", "no");
			hm.put("msg", "비밀번호가 틀렸습니다.");
			if (checkPwd.equals(userPwd)) {
				hm.put("result", "ok");
				hm.put("msg", "");
			}
			Gson gs = new Gson();
			out.println(gs.toJson(hm));
		} else {
			res.sendRedirect("/error.jsp");
		}
	}
}