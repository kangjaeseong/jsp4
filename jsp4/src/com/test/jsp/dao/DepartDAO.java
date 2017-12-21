package com.test.jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.test.jsp.dto.DepartInfo;

public interface DepartDAO {

	public ArrayList<DepartInfo> selectDepartList() throws SQLException;

	public DepartInfo selectDepart();

	public void updateDepart();

	public void insertDepart();

}
