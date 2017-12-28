<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
	<from class="form-sigin" action="/depart/list" method="get">
	<select name="serchOption">
	<option value = "diName">부서이름</option>
	<option value = "diDesc">부서설명</option>
	 </select>
	<input type="text" id= "diName" name="diName" > <button>검색</button>
	</from>
	<br>
		<table id="table" date-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th class="text-center" data-field="userNo">부서번호</th>
					<th class="text-center" data-field="userId">부서이름</th>
					<th class="text-center" data-field="userAge">부서설명</th>

				</tr>
			</thead>
			<tbody id="result_tbody">
				<c:forEach items="${departList}" var="dp">
					<tr onclick="goView(${dp.diNo})">
						<td>${dp.diNo}</td>
						<td>${dp.diName}</td>
						<td>${dp.diEtc}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	function goView(diNo) {
		
		location.href = "/depart/view?dino=" + diNo;
	}
	</script>
</body>
</html>