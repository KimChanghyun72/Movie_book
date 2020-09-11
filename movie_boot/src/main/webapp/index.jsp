<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form id="frm" name="frm" method="get" action="movieSelectAll.do">
		<button>submit</button>
	</form>

	<div>${pageContext.request.contextPath}</div>
	<div>
		<c:if test="${not empty movieList}">
			<form id="frm2" name="frm2" method="get" action="timetableSelectAll.do">
				
				<select name="movie_code" id="movie_code" size="${fn:length(movieList)}">
					<c:forEach items="${movieList}" var="list">
						<option value="${list.movie_code}">${list.movie_name}${list.movie_code}
					</c:forEach>
				</select>
				
				<select name="theater_code" id="theater_code" size="${fn:length(theaterList)}">
					<c:forEach items="${theaterList}" var="list">
						<option value="${list.theater_code}">${list.theater_name}${list.theater_code}
					</c:forEach>
				</select>
				<button>submit</button>
			 </form>
		</c:if>
		<c:if test="${not empty ttList}">
					<select name="timetable_code" size="${fn:length(ttList)}">
						<c:forEach items="${ttList}" var="list">
							<option value="${list.timetable_code}">${list.start_time}
						</c:forEach>
					
					</select>
				</c:if>
	</div>
	<script>
		$(".movie_name").click()
	</script>
</body>
</html>