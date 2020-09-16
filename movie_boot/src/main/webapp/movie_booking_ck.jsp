<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 확인</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>


<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <h3>영화 예매 목록</h3>
        <tr>
            <th>영화이름</th>
            <th>상영관정보(1관,2관)</th>
            <th>좌석번호</th>
            <th>가격</th>
            
        </tr>
    </thead>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td class="text-center"><a class='btn btn-link btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span>수정(좌석번호 변경)</a> 
                <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>예매취소</a></td>
            </tr>
            
    </table>
    </div>
</div>
</body>
</html>