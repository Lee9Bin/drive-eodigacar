<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/layout/commonHead.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/kakao/kakaoMap.css">
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<article>
		<section class="section section--map">
			<div class="inner">

				<div class="summary">
					<div class="summary__title">여러분들의 다양한 드라이브 경험을 알려주세요!</div>
				</div>
				<div class="container">
					<!-- 글쓰기 버튼과 검색 -->
					<div class="search-container">
						<c:if test="${member != null}">
							<button type="button" id="btnWriteForm">글쓰기</button>
						</c:if>
						<div class="search-box">
							<select id="searchType">
								<option value="title">제목</option>
								<option value="reg_id">작성자</option>
							</select> <input type="text" id="keyword" placeholder="검색어를 입력하세요" />
							<button id="btnSearch">검색</button>
						</div>
					</div>

					<!-- 게시글 테이블 -->
					<div class="table-responsive">
						<table class="table table-striped table-sm">
							<colgroup>
								<col style="width: 5%;" />
								<col style="width: auto;" />
								<col style="width: 15%;" />
								<col style="width: 10%;" />
								<col style="width: 10%;" />
							</colgroup>
							<thead>
								<tr>
									<th>NO</th>
									<th>글제목</th>
									<th>작성자</th>
									<th>조회수</th>
									<th>작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty boardList}">
										<tr>
											<td colspan="5" align="center">게시글이 없습니다.</td>
										</tr>
									</c:when>
									<c:when test="${!empty boardList}">
										<c:forEach var="list" items="${boardList}">
											<tr>
												<td>${list.id}</td>
												<td><a href="#" onclick="fn_contentView('${list.id}')">${list.title}</a>
												</td>
												<td>${list.memberName}</td>
												<td>${list.viewCount}</td>
												<td>${list.createAt}</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</tbody>
						</table>
					</div>

					<!-- 페이지네이션 -->
					<ul class="pagination">
						<c:if test="${pagination.prev}">
							<li class="page-item"><a class="page-link" href="#"
								onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${search.searchType}', '${search.keyword}')">
									Previous </a></li>
						</c:if>
						<c:forEach begin="${pagination.startPage}"
							end="${pagination.endPage}" var="idx">
							<li
								class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}" />">
								<a class="page-link" href="#"
								onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${search.searchType}', '${search.keyword}')">
									${idx} </a>
							</li>
						</c:forEach>
						<c:if test="${pagination.next}">
							<li class="page-item"><a class="page-link" href="#"
								onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${search.searchType}', '${search.keyword}')">
									Next </a></li>
						</c:if>
					</ul>
				</div>

			</div>
		</section>
		<!--map-->
		<section class="section section--map">
			<div class="inner">
				<div class="summary">
					<div class="summary__title">카테고리 별로 검색해보세요</div>
					<div class="summary__description">아래의 버튼을 눌러보세요!</div>
				</div>
				<!-- 지도 -->
				<div id="map">
					<div class="map_wrap">
						<ul id="category">
							<li id="BK9" data-order="0"><span class="category_bg bank"></span>
								은행</li>
							<li id="MT1" data-order="1"><span class="category_bg mart"></span>
								마트</li>
							<li id="PM9" data-order="2"><span
								class="category_bg pharmacy"></span> 약국</li>
							<li id="OL7" data-order="3"><span class="category_bg oil"></span>
								주유소</li>
							<li id="CE7" data-order="4"><span class="category_bg cafe"></span>
								카페</li>
							<li id="CS2" data-order="5"><span class="category_bg store"></span>
								편의점</li>
						</ul>
					</div>
				</div>
			</div>
		</section>
	</article>

	<footer class="section">
		<div class="inner clearfix">
			<ul class="site-links float--right">
				<li><a href="https://web.kangnam.ac.kr/" target="_blank">강남대학교</a></li>
				<li><a href="https://developers.kakao.com/" target="_blank">KakaoDeveloper</a></li>
			</ul>
			<ul class="site-links float--left">
				<li>소프트웨어응용학부 201704071 이규빈</li>
			</ul>
			<a href="#" class="logo"> </a>
		</div>
	</footer>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67db8676f9e68a4cfa0568a0cd5a8115&libraries=services"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/kakaoMapCategory.js"></script>
</body>
</html>