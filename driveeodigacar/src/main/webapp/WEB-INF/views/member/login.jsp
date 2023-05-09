<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>드라이브 어디갈Car!</title>
<link rel="icon" href="/resources/img/icons8-car-roof-box-48.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/member/login.css">
</head>
<body>
	<h2>드라이브 어디갈Car!</h2>
	<div>
		<form accept-charset="UTF-8" method="post" action="/member/login">
			<input type="text" placeholder="아이디" class="in" id="email"
				name="email"> <input type="password" placeholder="비밀번호"
				class="in" id="password" name="password"> <input
				type="submit" id="btn" value="로그인">
			<c:if test="${msg == false}">
				<a style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</a>
			</c:if>
			<br>
		</form>
		<a href="http://localhost:8080/member/join" target="_blank">계정이
			없으신가요?</a>
	</div>
</body>
</html>