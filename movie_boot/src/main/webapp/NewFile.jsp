<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

</head>
<body>

<div class="container">
	<div class="row">
		<h2>예매 정보 확인</h2>
		
		<p id="errornull" class="text-danger"></p>
  <form class="mt-2" method="" id="contactback" action="">
<div class="form-group ">

<div class="form-group">
<input type="text" class="form-control" id="ctnamedk" name="ctname" placeholder="" autocomplete="off" required>
</div>
<div class="form-group">
<input type="email" class="form-control" id="ctemaildk" name="ctemail" placeholder="" autocomplete="off" required>
<p id="errmail_box" class="text-danger"></p>
</div>
<div class="form-group">
<input type="numbers" class="form-control" id="ctphonedk" name="ctphone" placeholder="" autocomplete="off" onkeyup="autoTab(this)" maxlength="12" required>
<p id="errnumonly" class="text-danger"></p>
</div>
<div class="form-group">
<textarea rows="4" cols="50" class="form-control" id="cttopicdk" name="cttopic" placeholder="" autocomplete="off" required></textarea>
</div>
<div class="form-group">
<button type="button" id="btnSendmail" name="button" class="btn btn-warning text-white">예매확인</button>
</div>
</div>
</form>
	</div>
</div>
</body>
</html>