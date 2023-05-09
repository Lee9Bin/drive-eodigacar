<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/views/layout/commonHead.jsp" %>
<!-- Kakao Map CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/kakao/kakaoMap.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div class="body__container">
		<!--visual-->
		<section class="section section--visual">
			<div class="inner">
				<div class="summary">
					<div class="summary__title">여기서&nbsp;드라이브 코스를&nbsp;검색해보세요!</div>
					<div class="summary__description">그동안 매번 드라이브 코스를 찾아보기
						번거로우셨죠!&nbsp;여기서 소통도 하고 정보도 얻어가세요!</div>
				</div>
			</div>
		</section>

		<!--map-->
		<section class="section section--map">
			<div class="inner">

				<div class="summary">
					<div class="summary__title">지도를 통해 목적지를 검색해보세요!</div>
					<div class="summary__description">목적지를 검색하고 가는 길에 둘러볼만한 곳을
						봐보세요!</div>
				</div>
				<!-- 지도에 뛰운 검색창 -->
				<div class="map_wrap">
					<!-- 지도 -->
					<div id="map"></div>
					<div id="menu_wrap" class="bg_white">
						<div class="option">
							<div>
								<form onsubmit="searchPlaces(); return false;">
									검색 : <input type="text" value="강남대학교" id="keyword" size="15">
									<button type="submit">검색하기</button>
								</form>
							</div>
						</div>
						<hr>
						<ul id="placesList"></ul>
						<div id="pagination"></div>
					</div>
				</div>
			</div>
		</section>
		<%@ include file="/WEB-INF/views/layout/footer.jsp" %>	
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67db8676f9e68a4cfa0568a0cd5a8115&libraries=services"></script>
	<script src="${pageContext.request.contextPath}/resources/js/kakaoMap.js"></script>
</body>
</html>