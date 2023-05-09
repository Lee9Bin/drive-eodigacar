<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="section">
	<div class="inner clearfix">
		<div class="menu-group float--left">
			<div class="logo">
				<a href="#">Drive</a>
			</div>
			<ul class="main-menu">
				<li><a
					href="${pageContext.request.contextPath}/board/getBoardList">게시판</a></li>
				<li><a href="https://weather.naver.com/today/09620102"
					target="_blank">오늘의 날씨</a></li>
			</ul>
		</div>
		<div class="sign-group float--right">
			<div class="btn-group">
				<c:if test="${member != null}">
					<span style="padding:8px 8px 0 0;">${member.name}님 환영합니다.</span>
					<a href="/member/logout" class="btn sign-in">로그아웃</a>
				</c:if>
				<c:if test="${member == null}">
					<a href="/member/login" class="btn sign-in">로그인</a>
					<a href="/member/join" class="btn btn--primary sign-up">회원가입</a>
				</c:if>
			</div>
		</div>
	</div>
</header>