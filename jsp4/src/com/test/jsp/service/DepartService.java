package com.test.jsp.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;

public interface DepartService {
	public ArrayList<DepartInfo> selectDepartList(String search,String searchStr);

	public DepartInfo selectDepart(int diNo);

	public DepartInfo selectDepart();

	public void updateDepart(HttpServletRequest req);

	public void insertDepart(HttpServletRequest req);
}