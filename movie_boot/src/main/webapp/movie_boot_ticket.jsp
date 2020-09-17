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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">

.json_a {
	height: 100%;
	margin-top: auto;
	margin-left: 350px;
	text-align: center;
	font-weight: 600;
	border: 1px solid darkblue;
	width: 1200px;
	height: 600px;
}

.json_a:befor {
	content: "";
	display: inline-block;
	width: 1px;
	height: 100%;
	margin-right: 0;
	vertical-align: middle;
}

input[type=radio]:checked +label {
	background: #800080;
	color: white;
}

.ck,input[type=radio] +label {
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

	function ck() {
		$('.seats').on('click',function(){
			$("#seat_number").val($(this).val());
		});
		/*
		for (var i = 0; i < $("[name='ck']").length; i++) {
			if ((i > 10) && (i % 11 != 0)) {
				$("[name='ck']")
						.eq(i)
						.on(
								"click",
								function() {
									if ($(this).text() !== "X") {
										$("#seat_number").attr("value",
												$(this).text());
										$(this).addClass("ck");
									}
									;
									for (var j = 0; j < $("[name='ck']").length; j++) {
										if ($("[name='ck']").eq(j).text() != $(
												"#seat_number").val()) {
											$("[name='ck']").eq(j).removeClass(
													"ck");
										}
									}
								});
			}*/

			/* $("[name='ck']").on("click", function(){
				$("[name='ck']").removeClass("ck");
				$(this).addClass("ck");
			}); */

			//주석처리			
			/*  if($(this).attr("class")=="ck" || $(this).text()=="X"){
				$(this).removeClass("ck");
			} else {
			$(this).addClass("ck");
			} */

		//}

	}
	$(function(){
		 $("#btnOk").on("click" , function(){
			 $("#seat_number1").val($("#seat_number").val())
		 });

			$(".btnReset").on("click", function() {
				$(".seats").each(function(){
					console.log($(this).prop("checked"));
					$(this).prop("checked",false);
				});
				$("#seat_number").val('');
				/*$("#seat_number").val("");
				$("[name='ck']").each(function(){
					$(this).removeClass('ck');
				});*/
			});
		 ck();
	 });
	 


	//추가된부분
	<c:forEach items="${seatNum}" var="list">
	$(function() {
		for (var i = 0; i < $("[name=ck]").length; i++) {
			if ($("[name=ck]").eq(i).text() == "${list}") {
				$("[name=ck]").eq(i).text("X");
			}
		}

	});
	</c:forEach>
</script>
</head>
<body>

	<div class="json_a">
		<div class="row">
			<div name="screen">Screen</div>

			<div class="col-7">
				<div>
					<c:forEach var="i" begin="0" end="10" varStatus="s">
						<c:if test="${s.index == 0 }">
							<label class="ck" for="text${i}" style="visibility: hidden;">${i}</label>
						</c:if>
						<c:if test="${s.index > 0 }">
							<label class="ck" for="text${i}">${i}</label>
						</c:if>
					</c:forEach>
				</div>
				<div class="json_c">
					<c:forTokens items="A|B|C|D|E|F|G|H|I|J" delims="|" var="ch">

						<input type="text" id="button${ch}${i}"  style='display: none;'>
						<label class="ck" for="button${ch}${i}">${ch}${i}</label>



						<c:forEach var="j" begin="1" end="10">
							<input type="radio"  name='seats' class="seats" id="button${ch}${j}"  value="${ch}${j}" style="display: none;">
							<label for="button${ch}${j}">${ch}${j}</label>
						</c:forEach>
						<br>
					</c:forTokens>


					<input id="seat_number" name="seat_number">
					<button type="button" id="btnOk">선택 완료</button>

					<input type="button" class="btnReset" value='초기화'>

				</div>
			</div>
			<div class="col-3" style="padding-right: 60px;">
				<h2>예매 정보 확인</h2>

				<p id="errornull" class="text-danger"></p>
				<form class="mt-2" id="contactback" action="movieBookInsert.do">
					<div class="form-group ">

						<div class="form-group">
							<input type="text" class="form-control" id="movie_code"
								name="movie_name" value="${movieInfo.movie_name}" autocomplete="off" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="timetable_code"
								name="timetable_code" value="${timetable_code}" autocomplete="off"
								required>
							<p id="errmail_box" class="text-danger"></p>
						</div>
						<div class="form-group">
							<input type="numbers" class="form-control" id="seat_number1" name="seat_number" value="${param.seat_number}" autocomplete="off"
								onkeyup="autoTab(this)" maxlength="12" required>
							<p id="errnumonly" class="text-danger"></p>
						</div>
						<div class="form-group">
							<input type="numbers" class="form-control" id="final_price"
								name="final_price" value="${movieInfo.movie_price*ageComm_pct/10}" autocomplete="off"
								onkeyup="autoTab(this)" maxlength="12" required>
							<p id="errnumonly" class="text-danger"></p>
						</div>

						<div class="form-group">
						</div>
					</div>
							<button type="submit" id="btnSendmail" name="button"
								class="btn btn-warning text-white">예매확인</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>