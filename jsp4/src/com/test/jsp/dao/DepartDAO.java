package com.test.jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.dto.DepartInfo;

public interface DepartDAO {
	public ArrayList<DepartInfo> selectDepartList() throws SQLException;

	public DepartInfo selectDepart(int diNo) throws SQLException;

	public void updateDepart();

	public void insertDepart();

	ArrayList<DepartInfo> selectDepartList(String search, String searchStr) throws SQLException;
}