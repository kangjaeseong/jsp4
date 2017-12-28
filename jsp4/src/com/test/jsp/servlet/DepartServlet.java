package com.test.jsp.servlet;

import java.io.IOException;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;

public class DepartServlet extends HttpServlet {
	DepartService ds = new DepartServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	private String getCommandFormUri(String uri) {
		int idx = uri.lastIndexOf("/");
		if (idx != -1) {
			return uri.substring(idx + 1);
		}
		return uri;
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String str = req.getCharacterEncoding();
		System.out.println(str);
		String uri = req.getRequestURI();
		String cmd = getCommandFormUri(uri);
		System.out.println(cmd);
		if (cmd.equals("list")) {
			String search = req.getParameter("searchOption");
			String searchStr = req.getParameter("diName");
			Map<String,String[]> param = req.getParameterMap();
			Iterator<String> it = param.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				System.out.println("[" + key + "] : " + param.get(key));
			}
			req.setAttribute("departList", ds.selectDepartList(searchStr, searchStr));
			System.out.println(param);
		} else if (cmd.equals("view")) {
			String diNo = req.getParameter("dino");
			System.out.println(diNo);
			req.setAttribute("depart", ds.selectDepart(Integer.parseInt(diNo)));
		} else if (cmd.equals("update")) {
			req.setAttribute("depart", ds.selectDepart());
		} else if (cmd.equals("insert")) {

		} else {
			uri = "/error";
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/" + uri + ".jsp");
		rd.forward(req, res);
	}
}
