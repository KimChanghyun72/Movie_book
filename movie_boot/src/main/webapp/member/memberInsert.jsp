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
            <h5 class="card-title text-center">회원가입</h5>
            <form class="form-signin" method="post" name="frm" id="frm"
			action="${pageContext.request.contextPath}/memberInsert.do"
			onsubmit="return inputCheck()">
              <div class="form-label-group">
               <label for="inputUserame">아이디</label><br>
                <input type="text" name="id">
              </div>
              
              <div class="form-label-group">
               <label for="inputPassword">패스워드</label><br>
               <input type="password" id="password" class="form-control" name="password" placeholder="Password" required>
              </div>
              
               <div class="form-label-group">
                <label for="inputConfirmPassword">확인</label><br>
                <input type="password" id="password" class="form-control" name="password">
               
              </div>

              <div class="form-label-group">
               <label for="inputAge">나이</label><br>
                <input type="text" id="age" name="age">

              </div>
              
              <hr>


              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">회원가입</button>
              <a class="d-block text-center mt-2 small" href="#">로그인</a>
              <hr class="my-4">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i>구글로 로그인</button>
              <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign up with Facebook</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
</body>
</html>