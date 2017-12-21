package com.test.jsp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.dto.UserInfo;

public class UserServiceImpl implements UserService {

	public UserInfo getUser(String id, String pwd) throws ClassNotFoundException, SQLException {

		DBCon dbCon = new DBCon();
		Connection con = dbCon.getConnection();
		String sql = "select * from user_info ui, " + " depart_info di" + " where ui.dino = di.dino";

		sql += " and ui.userid=? and ui.userpwd=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id); // ?하나면 1= 바인딩
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery(); // sql 실행
		UserInfo ui = null;

		while (rs.next()) { // 펄스일때 까지 작동
			ui = new UserInfo();
			ui.setUserNo(rs.getInt("userno"));
			ui.setUserName(rs.getString("username"));
			ui.setUserId(rs.getString("userId"));
			ui.setUserPwd(rs.getString("userPwd"));
			ui.setUserAddress(rs.getString("userAddress"));
			ui.setDiNo(rs.getString("dino"));
			ui.setUserAge(rs.getInt("userAge"));
		}
		return ui;
	}

	public ArrayList<UserInfo> getUserList() {
		ArrayList<UserInfo> al = new ArrayList<UserInfo>();

		DBCon dbCon = new DBCon();
		try {

			Connection con = dbCon.getConnection();
			String sql = "select * from user_info ui, " + " depart_info di" + " where ui.dino = di.dino";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // sql 실행

			while (rs.next()) { // 펄스일때 까지 작동
				UserInfo ui = new UserInfo();
				ui.setUserNo(rs.getInt("userno"));
				ui.setUserName(rs.getString("username"));
				ui.setUserId(rs.getString("userid"));
				ui.setUserPwd(rs.getString("userpwd"));
				ui.setUserAddress(rs.getString("useraddress"));
				ui.setUserAge(rs.getInt("userage"));

				al.add(ui);
			}
			return al;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return al;
	}

	public int insertUser(HashMap hm) {
		int result = 0;
		DBCon dbCon = new DBCon();
		try {

			Connection con = dbCon.getConnection();
			String sql = "insert into user_info(usernmae,userid,";
			sql += "userpwd,userage,useraddress)";
			sql += "values(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, (String) hm.get("name"));
			ps.setString(2, (String) hm.get("id"));
			ps.setString(3, (String) hm.get("pwd"));
			ps.setString(4, (String) hm.get("age"));
			ps.setString(5, (String) hm.get("address"));
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateUser(UserInfo ui) {
		int result = 0;
		DBCon dbCon = new DBCon();
		try {
			Connection con = dbCon.getConnection();
		String sql="update user_info\r\n" + 
				"set username=?,\r\n" + 
				"userapwd=?,\r\n" + 
				"userage=?,\r\n" + 
				"useraddress=?,\r\n" + 
				"dino=?\r\n" + 
				"where\r\n" + 
				"userno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ui.getUserName());
		ps.setString(2, ui.getUserPwd());
		ps.setInt(3, ui.getUserAge());
		ps.setString(4, ui.getUserAddress());
		ps.setInt(5, 1);
		ps.setInt(6, ui.getUserNo());
		result = ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			dbCon.closeCon();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
		return result;
	}

	public int insertUser(UserInfo ui) {
		int result = 0;
		DBCon dbCon = new DBCon();
		try {

			Connection con = dbCon.getConnection();
			String sql = "insert into user_info(username,userid,";
			sql += "userpwd,userage,useraddress)";
			sql += "values(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserId());
			ps.setString(3, ui.getUserPwd());
			ps.setInt(4, ui.getUserAge());
			ps.setString(5, ui.getUserAddress());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public UserInfo getUser(int userNo) {

		DBCon dbCon = new DBCon();
		Connection con = null;
		UserInfo ui = null;
		try {
			con = dbCon.getConnection();
			String sql = "select * from user_info ui, " + " depart_info di" + " where ui.dino = di.dino";

			sql += " and ui.userNo=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ui = new UserInfo();
				ui.setUserNo(rs.getInt("userno"));
				ui.setUserName(rs.getString("username"));
				ui.setUserId(rs.getString("userId"));
				ui.setUserPwd(rs.getString("userPwd"));
				ui.setUserAddress(rs.getString("userAddress"));
				ui.setDiNo(rs.getString("dino"));
				ui.setUserAge(rs.getInt("userAge"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ui;
	}

	@Override
	public int deleteUser(UserInfo ui) {

		int result = 0;
		DBCon dbCon = new DBCon();
		try {

			Connection con = dbCon.getConnection();
			String sql = "select count(1) from user_info" + " where userno=? and userpwd=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ui.getUserNo());
			ps.setString(2, ui.getUserPwd());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int cnt = rs.getInt(1);
				if(cnt==1) {
					sql = "delete from user_info" + " where userno=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1,ui.getUserNo());
					result = ps.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}
}
