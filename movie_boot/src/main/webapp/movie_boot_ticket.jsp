<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석표</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style type="text/css">
.json_a {
	height: 100%;
	margin-top: auto;
	text-align: center;
	font-weight: 600;
	border: 1px solid black;
	width: 700px;
	height: 550px;
}

.json_a:befor {
	content: "";
	display: inline-block;
	width: 1px;
	height: 100%;
	margin-right: 0;
	vertical-align: middle;
}

.json_b {
	display: inline-block vertical-align: middle;
}

.ck {
	background: #800080;
	color: white;
}

label[name=ck] {
	display: inline-block;
	background: #fffffff;
	border: 1px solid #000000;
	width: 29px;
	height: 29px;
	text-align: center;
}

div[name=screen] {
	width: 400px;
	height: 50px;
	text-align: center;
	margin-left: 150px;
	margin-bottom: 50px;
	background-color: #a0a0a0;
}
</style>
<script>
	$(window).on("load", ck);
	function ck(){
		$("[name='ck']").on("click", function(){
			$("[name='ck']").removeClass("ck");
			$(this).addClass("ck");
		});	
	}
	function btnRset(){
		$("#btnReset").click(function(){
			$(".ck").removeAttr("ckecked", true);
		});
	}
		
</script>
</head>
<body>

	<div class="json_a">
		<div name="screen">Screen</div>
		<div class="json_b">
			<div>
				<c:forEach var="i" begin="0" end="10" varStatus="s">
					<c:if test="${s.index == 0 }">
						<label name="ck" for="text${i}" style="visibility: hidden;">${i}</label>
					</c:if>
					<c:if test="${s.index > 0 }">
						<label name="ck" for="text${i}">${i}</label>
					</c:if>
				</c:forEach>
			</div>
			<div class="json_c">
				<c:forTokens items="A|B|C|D|E|F|G|H|I|J" delims="|" var="ch">

					<input type="text" id="button${ch}${i}" style='display: none;'>
					<label name="ck" for="button${ch}${i}">${ch}${i}</label>



					<c:forEach var="j" begin="1" end="10">
						<input type="checkbox" id="button${ch}${j}" style="display: none;">
						<label name="ck" for="button${ch}${j}">${ch}${j}</label>
					</c:forEach>
					<br>
				</c:forTokens>


				<br>
				<button id="btnReset">초기화</button>
				<button>선택 완료</button>
			</div>
		</div>
	</div>

</body>
</html>