<%@page import="java.util.Iterator"%>
<%@page import="com.test.jsp.service.ListExam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>

<%@ include file="/common/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트 테스트</title>
</head>
<body>

	jstl's test : ${test}
	<br> 
	session test : ${s_test}
	<br>
	application test : ${a_test}
	<%
	String[] strs = {"1","2","3",};
	request.setAttribute("strArray",strs);
	UserInfo[] userList = new UserInfo[3];
	UserInfo ui = new UserInfo();
	ui.setUserName("test");
	userList[0] = ui;
	ui = new UserInfo();
	ui.setUserName("test2");
	userList[1] = ui;
	ui = new UserInfo();
	ui.setUserName("test3");
	userList[1] = ui;
	
	request.setAttribute("userList",userList);
	
	%>
	<c:forEach var ="str" items="${strArray}">
	${str},
	</c:forEach>
	<table border="1">
	<tr>
	<tr>유저이름</tr>
	</tr>
	<c:forEach var="ui" items="${userList}">
	<tr>
	<td>${ui.userNo}</td>
	<td>${ui.userName}</td>
	<td>${ui.userAge}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>