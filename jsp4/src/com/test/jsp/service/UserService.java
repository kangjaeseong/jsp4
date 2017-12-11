package com.test.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {

	public ArrayList<HashMap<String, String>> getUserList(); 

	public HashMap<String,String> getUser(String id , String pwd) throws ClassNotFoundException, SQLException; 
		
	
	

	}
