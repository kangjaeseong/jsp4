<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>


<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css" />
<body>

	<script>
function afterView(result){
	for(var key in result){
		$("#"+ key).val(result[key]);
		
	}
	
	}

$(document).ready(function() {
	var url = "join.user"
	var param = {};
	param["cmd"] = "view"
	param["userno"] = "<%=request.getParameter("userno")%>";
			$.ajax({
				type : "post",
				url : url,
				dataType : "json",
				data : param,
				success : afterView,
				error : function(xhr, status) {
					alert("에러 :" + xhr.responseText);
				}

			});

		})
	</script>

	<form class="form-signin">
		<h2 class="form-signin-heading">회원정보</h2>

	<input type="text" id="userId" name="id" class="form-control" 
			placeholder="ID" required autofocus disabled>
		
		<label for="pwd" class="sr-only">Password</label>
		<input type="password" name="pwd" id="userPwd" class="form-control"
			placeholder="Password" required disabled>
			
		<label for="id" class="sr-only">이름</label> 
		<input type="text" id="userName" name="name" class="form-control" 
			placeholder="이름" required disabled> 
			
		<label for="id" class="sr-only">나이</label> 
		<input type="text" id="userAge" name="age" class="form-control" 
			placeholder="나이" required disabled>  
			
		<label for="id" class="sr-only">주소</label> 
		<input type="text" id="userAddress" name="address" class="form-control" 
			placeholder="주소" required disabled>

		<%
			if (user != null && user.getUserNo().toString().equals(request.getParameter("userno"))) {
		%>

		
		
		<input type="text" id="checkPwd" name="checkPwd">
		<button type="button">회원 수정</button>
		<button  type="button" onclick="deleteUser()">회원탈퇴</button>
		
<script>
function afterDelete(result){
	alert(result.msg);
	if(result.result=="ok"){
		location.href = result.url;
	}
}
function deleteUser(){
	var url = "delete.user";
	var param = {};
	param["cmd"] = "delete";
	param["checkPwd"] = $("#checkPwd").val();
	$.ajax({
		type : "post",
		url : url,
		dataType: "json",
		data : param,
		success : afterDelete,
		error : function(xhr,status){
			alert("에러 : " + xhr.responseText);
		}
	});
}
</script>
<%
}
%>
	</form>
</body>
</html>