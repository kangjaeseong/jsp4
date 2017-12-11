<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP4</title>
</head>
<script>
var AjaxUtil = function(p_url, p_params, p_method,p_aSync){
	if(!p_url || p_url.trim()==""){
		alert("AjaxUtil호출시 url은 필수 입니다.");
		return;
	}
	this.params = p_params;
	var getHttpXmlObj = function(){
		if(window.XMLHttpRequest){
	  		return new XMLHttpRequest();
	 	}else if(window.ActiveXObject){
	  		return new ActiveXObject("Microsoft.XMLHTTP");
	 	}
		alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
	}
	this.xhr = getHttpXmlObj();
	var method = p_method?p_method:"get";
	var url = p_url;
	
	var aSync = p_aSync?p_aSync:true;
	this.xhr.callback = null;
	this.xhr.onreadystatechange=function(){
   		if (this.readyState==4){
   			if(this.status==200){
	   			var result = decodeURIComponent(this.responseText);
	   			if(this.callback){
	   				this.callback(result);
	   			}else{
	   				alert(result);
	   			}
   			}else{
	   			var result = decodeURIComponent(this.responseText);
	   			alert(result);
   			}
   		}
	}
	this.changeCallBack = function(func){
		this.xhr.callback = func;
	}
   	this.xhr.open(method, url+this.params, aSync);
   	this.send = function(){
   		this.xhr.send.arguments = this;
   	   	this.xhr.send();
   	}
}
</script>
<body>


	<table border="1">
		<tr>
			<td><a href="/index.jsp">home</a></td>
			<td><a href="/user/login.jsp">로그인</a></td>
			<td><a href="#">회원가입</a></td>
			<td><a href="#">게시판</a></td>
			<td><a href="/user/List.jsp">유저리스트</a></td>
		</tr>


	</table>
	<%
		String str1 = "이름1";
		String str2 = "나이2";
	%>


</body>
</html>