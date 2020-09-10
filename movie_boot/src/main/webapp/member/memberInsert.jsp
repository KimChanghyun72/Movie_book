<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	function inputCheck() {
		//id, pw 필수입력 체크
		if (frm.id.value == "") {
			window.alert("id 를 입력해주세요.");
			frm.id.focus();
			return false;
		}
		if (frm.password.value == "") {
			alert("password를 입력해주세요");
			frm.password.focus();
			return false;
		}
		if (frm.phone_number.value == "") {
			alert("phone_number를  입력해주세요.");
			frm.phone_number.focus();
			return false;
		}
		if (frm.age.value == "") {
			alert("age를  입력해주세요.");
			frm.age.focus();
			return false;
		}

		//회원가입폼 제출
		//frm.submit();
		return true;
	}
</script>
</head>
<body>
	<div class="regist">

		<form method="post" name="frm" id="frm"
			action="${pageContext.request.contextPath}/memberInsert.do"
			onsubmit="return inputCheck()">
			<h3 class="page_title">회원가입</h3>
			<div>
				<label for="id">id</label><input type="text" name="id">
			</div>

			<div>
				<label for="password">password</label> <input type="password"
					id="password" name="password">
			</div>
			<div>
			
				<label for="phone_number">phone_number</label> <input type="text"
					id="phone_number" name="phone_number">
			</div>
			
			<div>
			
				<label for="age">age</label> <input type="text"
					id="age" name="age">
			</div>


			<div>
				<button type="reset">초기화</button>
				<!-- <button type="button" onclick="inputCheck()">등록</button> -->
				<button>등록</button>
			</div>


		</form>
	</div>
</body>
</html>