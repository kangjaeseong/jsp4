package com.test.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;


import com.test.jsp.dao.DepartDAO;
import com.test.jsp.dao.DepartDAOImpl;
import com.test.jsp.dto.DepartInfo;

public class DepartServiceImpl implements DepartService{
	
	@Override
	public ArrayList<DepartInfo> selectDepartList(String search,String searchStr) {
		ArrayList<DepartInfo> departList = null;
		DBCon dbCon = new DBCon();
		try {
			DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
			departList = ddao.selectDepartList();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departList;
	}

	@Override
	public DepartInfo selectDepart(int diNo) {
		DepartInfo di = null;
		DBCon dbCon = new DBCon();
		try {
			DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
			di = ddao.selectDepart(diNo);
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return di;
	}

	@Override
	public DepartInfo selectDepart() {
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("dino", 1);
		hm.put("diname",1+"번째 부서");
		hm.put("didesc",1+"번째 부서 설명");
		return null;
	}

	@Override
	public void updateDepart(HttpServletRequest req) {
	}

	@Override
	public void insertDepart(HttpServletRequest req) {
	}

}