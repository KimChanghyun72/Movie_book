<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
$(function(){
	<c:forEach items="${seatNum}" var="list">
	for(var i=0; i<10; i++){
		for(var j=0; j<10; j++){
			if($('#'+i+j).val()==${list}){
				$('#'+i+j).parent().html("매진");
			}		
		}
	} 
	</c:forEach>
	/* var seatNum = "${fn:replace(fn:replace(seatNum,'[',''),']','')}";
	if($("#11").val()==seatNum){
		$("#11").parent().html("매진");
	} */
	$("button[name=seatVal]").on("click", function(){
		$("input#seat_number").val($(this).val());
	});
});
</script>

</head>
<body>
	<table border="1">
		<%-- <c:forEach items="${seatNum}" var="list">
	<c:if test="${seatNum==$('td').text()} "></c:if>
	<tr>
		<td>매진</td>
	</tr>
</c:forEach>
 --%>
		<c:forEach var="i" begin="0" end="9">
			<tr>
				<c:forEach var="j" begin="0" end="9">
					<td><button name="seatVal" id="${i}${j}" value="${i}${j}">${i}${j}</button></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<form id="seat_choice" method="get" action="movieBookInsert.do">
		<input id="seat_number" name="seat_number">
		<button>결제</button>
	</form>


</body>
</html>