<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp</title>
<script>
	if('${errorCode}'==1){
		alert('${error}');
		}
</script>
</head>
<body>
<h3>회원 검색</h3>
<!-- ../memberList.do 
"/webFront20200907/membetList.do" -->

<a href="${pageContext.request.contextPath}/memberList.do">전체검색</a>

	<form action="${pageContext.request.contextPath}/memberSearch.do">
				<input type="hidden" name="job" value="search">
		id : <input name="id">
		<button>검색</button>

	</form>
	<div>${error}</div>

</body>
</html>