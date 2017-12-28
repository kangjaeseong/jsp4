package com.test.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.dto.UserInfo;

public interface UserService {
	public ArrayList<UserInfo> getUserList();

	public UserInfo getUser(String id, String pwd) throws ClassNotFoundException, SQLException;

	public UserInfo getUser(int userNo);

	public int insertUser(HashMap hm);

	public int insertUser(UserInfo ui);

	public int deleteUser(UserInfo ui);

	int updateUser(UserInfo ui);
}