<%@page import="com.test.jsp.dto.UserInfo"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP4</title>
</head>
<%
String rootPath = request.getContextPath();
UserInfo user = null;
user = (UserInfo) session.getAttribute("user");
String m2 = "로그인";
String u2 = "/user/login.jsp";
if(user!=null){
	m2 = "로그아웃";
	u2 = "/user/logout.user?cmd=logout";
}
%>

<script src="<%=rootPath%>/js/jquery-3.2.1.min.js"></script>
<script src="<%=rootPath%>/js/ajax_util.js"></script>
<script src="<%=rootPath%>/ui/btsp3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.3.2/css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.3.2/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css"/>
<body>
<script>
$(document).ready(function(){
	$("table[id='menu'] tr td").click(function(){
		location.href=this.getAttribute("data-url");
	})
})
</script>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar">home</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=rootPath%>/">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=rootPath%>/">Home</a></li>
            <li><a href="<%=rootPath%>/user/login.jsp">login</a></li>
            <li><a href="<%=rootPath%>/user/join.jsp">join us</a></li>
             <li><a href="<%=rootPath%>/user/list.jsp">User List</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<br><br><br>
