package com.test.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.jsp.dto.DepartInfo;

public class DepartDAOImpl implements DepartDAO {
	
	private Connection con;

	public DepartDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<DepartInfo> selectDepartList() throws SQLException {
		String sql = "select * from depart_info"; // 테이터 통신
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<DepartInfo> diList = new ArrayList<DepartInfo>();
		DepartInfo di = null;
		while(rs.next()) {
			di = new DepartInfo();
			di.setDiNo(rs.getInt("dino"));
			di.setDiName(rs.getString("diname"));
			di.setDiEtc(rs.getString("dietc"));
			diList.add(di);
		} 

		return diList;
	}

	@Override
	public DepartInfo selectDepart() {

		return null;
	}

	@Override
	public void updateDepart() {

	}

	@Override
	public void insertDepart() {

	}

}
