<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script>
	function inputCheck() {
		//id, pw 필수입력 체크
		if (frm.id.value == "") {
			window.alert("id 입력");
			frm.id.focus();
			return false;
		}
		if (frm.password.value == "") {
			alert("pw 입력");
			frm.password.focus();
			return false;
		}

		return true;
	}
</script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<link href="../css/register.css" rel="stylesheet">
</head>
<body style="padding-top: 70px;">

	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="card card-signin flex-row my-5">
					<div class="card-img-left d-none d-md-flex">
						<!-- Background image for card set in CSS! -->

					</div>
					<div class="card-body">
						<h5 class="card-title text-center">회원 정보수정</h5>
						<form class="form-signin" method="post" name="frm" id="frm"
							action="${pageContext.request.contextPath}/memberUpdate.do"
							onsubmit="return inputCheck()">
							<div class="form-label-group">
								<label for="inputUserame">아이디</label><br> <input
									type="text" name="id" value=${id } readonly="readonly">
							</div>

							<div class="form-label-group">
								<label for="inputPassword">패스워드</label><br> <input
									type="password" id="password" class="form-control"
									name="password" placeholder="Password" required>
							</div>

							<div class="form-label-group">
								<label for="inputConfirmPassword">확인</label><br> <input
									type="password" id="password" class="form-control"
									name="password">

							</div>
							<div class="form-label-group">
								<label for="inputPhone_number">핸드폰 번호</label><br> <input type="text"
									id="phone_number" name="phone_number">

								<div class="form-label-group">
									<label for="inputAge">나이</label><br> <input type="text"
										id="age" name="age">
								</div>

								<hr>
								<div><a href="/member/memberDelete">회원탈퇴</a></div>
								<button class="btn btn-lg btn-primary btn-block text-uppercase"
									type="submit">수정</button>
								<hr class="my-4">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="assets/mail/jqBootstrapValidation.js"></script>
	<script src="assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>