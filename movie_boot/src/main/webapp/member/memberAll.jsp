<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>

	<h3 class="page_title">전체 회원 조회</h3>
	<div>

	</div>
	<table id="members" border=1>
		<thead>
			<tr>
				<th>id</th>
				<th>password</th>
				<th>phone_number</th>
				<th>age</th>
			</tr>
		</thead>

		<tbody>
		<c:forEach items="${list}" var="temp">
		
			<tr>
				<td><a href="memberAll.jsp">${temp.id}</a></td>
				<td>${temp.password}</td>
				<td>${temp.phone_number}></td>
				<td>${temp.age}</td>
			</tr>
			 </c:forEach>
		</tbody>

	</table>

</body>
</html>