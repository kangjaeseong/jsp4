package com.test.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.dto.UserInfo;

public interface UserService {

	public ArrayList<HashMap<String, String>> getUserList();

	public UserInfo getUser(String id, String pwd) throws ClassNotFoundException, SQLException;

}
