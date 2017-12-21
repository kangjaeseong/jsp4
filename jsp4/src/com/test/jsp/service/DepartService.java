package com.test.jsp.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;

public interface DepartService {
	public ArrayList<DepartInfo> selectDepartList();

	public HashMap<String, Object> selectDepart();

	public void updateDepart(HttpServletRequest req);

	public void insertDepart(HttpServletRequest req);

}
