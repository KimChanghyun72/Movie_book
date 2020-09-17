<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 확인</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script>
$(function(){
	$("a.btn.btn-danger").on("click", function(){
		$("#delInput").attr("value", $(this).closest("tr").children().eq(0).html());
		$("#frm").submit();
	})
	$("a.btn.btn-link").on("click", function(){
		$("#updInput").attr("value", $(this).closest("tr").children().eq(0).html());
		$("#frm2").submit();
	})
	
})
</script>
</head>
<body>


<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <h3>영화 예매 목록</h3>
        <tr>
        	<th>예매번호</th>
            <th>영화이름</th>
            <th>상영관정보(1관,2관)</th>
            <th>좌석번호</th>
            <th>가격</th>
            
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${movieBookList}" var="list">
    		<tr>
    			<td>${list.ticket_num}</td>
    			<td>${list.movie_name}</td>
    			<td>${list.theater_name}</td>
    			<td>${list.seat_code}</td>
    			<td>${list.final_price}</td>
    			<td class="text-center">
    			<!-- <a class='btn btn-link btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span>수정(좌석번호 변경)</a> --> 
                <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>예매취소</a></td>
    		</tr>
    	</c:forEach>
    </tbody>
    </table>
    <form id="frm" name="frm" action="movieBookingDelete.do">
		<input type="hidden" name="ticket_num" id="delInput">
    </form>
    <form id="frm2" name="frm2" action="movieSelectAll_sec.do">
    	<input type="hidden" name="updInput" id="updInput">
    </form>
    </div>
</div>
</body>
</html>