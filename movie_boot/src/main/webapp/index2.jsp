<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("select[name=movie_choice]").val("${movie_choice}");
	$("select[name=theater_choice]").val("${theater_choice}");
	
	console.log($("select[name=movie_choice]").val());
	console.log($("select[name=theater_choice]").val());
	
	
	$("#cancel").click(function(){
		$("select[name=movie_choice]").val("");
		$("select[name=theater_choice]").val("");
		$("select[name=timetable_choice]").val("");
		
		console.log($("select[name=movie_choice]").val());
		console.log($("select[name=theater_choice]").val());
		
	});
})

</script>
</head>
<body>
<form id="frm1" name="frm1" action="movieSelectAll.do">
	<select name="movie_choice">
		<option value="m001">영화1
		<option value="m002">영화2
		<option value="m003">영화3
	</select>
	
	<%-- <c:if test="${not empty movieList}">
		<select name="theater_choice">
			<c:forEach items="${movieList}" var="list">
				<option value="${list.movie_code}">${list.movie_name}
			</c:forEach>		
		</select>
	</c:if>
	 --%>
	<c:if test="${not empty theaterList}">
		<select name="theater_choice">
			<c:forEach items="${theaterList}" var="list">
				<option value="${list.theater_code}">${list.theater_name}
			</c:forEach>		
		</select>
	</c:if>
	
	<c:if test="${not empty timetableList}">
		<select name="timetable_choice">
			<c:forEach items="${timetableList}" var="list">
				<option value="${list.timetable_code}">${list.start_time}
			</c:forEach>		
		</select>
	</c:if>
	<button>submit</button>
</form>
<button id="cancel">취소</button>

</body>
</html>