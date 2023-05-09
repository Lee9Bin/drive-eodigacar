<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>드라이브 어디갈Car!</title>
<link rel="icon" href="/resources/img/icons8-car-roof-box-48.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/member/join.css">
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form class="validation-form" action="/member/join" method="post"
					accept-charset="utf-8" id="registerForm">
					<div class="mb-3">
						<label for="memberName">이름</label> <input type="text"
							class="form-control" id="memberName" name="name" required>
					</div>

					<div class="mb-3">
						<label for="memberMail">이메일</label> <input type="email"
							class="form-control" id="memberMail" name="email" required>
						<button class="btn btn-secondary mt-2" type="button" id="emailChk"
							onclick="fn_idChk();">중복확인</button>
					</div>

					<div class="mb-3">
						<label for="memberPw">비밀번호</label> <input type="password"
							class="form-control mb_check" id="memberPw" name="password"
							required>
					</div>

					<div class="mb-3">
						<label for="check">비밀번호 확인</label> <input type="password"
							class="form-control mb_check" id="check" required> <small
							id="checkPw" class="form-text"></small>
					</div>

					<div class="mb-3">
						<label for="memberAddr1">주소</label> <input type="text"
							class="form-control" id="memberAddr1" name="address1" required>
					</div>

					<div class="mb-3">
						<label for="memberAddr2">상세주소 <span class="text-muted">(선택)</span></label>
						<input type="text" class="form-control" id="memberAddr2"
							name="address2">
					</div>

					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="agreement"
							required> <label class="form-check-label" for="agreement">개인정보
							수집 및 이용에 동의합니다.</label>
					</div>

					<button class="btn btn-primary btn-lg btn-block mt-3" type="submit"
						onclick="return registerCheck();">가입 완료</button>
				</form>

			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/join.js"></script>
</body>
</html>
