<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
<script>
	if ('${error}' != '') {
		alert('ddddd');
	}
</script>

</head>
<body>
	<h3>회원 삭제</h3>
	<form action="${pageContext.request.contextPath}/memberSearch.do">
		<input type="hidden" name="job" value="delete"> id : <input
			name="id">
		<button>검색</button>
	</form>
 <c:if test="${not empty member}">
		<h3>검색 결과</h3>
			${membet.job}<br>
			${membet.gender}<br>
			${membet.id}
	<form action="${pageContext.request.contextPath}/memberDelete.do">
			<input name="id" value="${member.id}" type="hidden">
			<button>삭제</button>
	</form>
 </c:if>
</body>
</html>