<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/layout/commonHead.jsp"%>
<script>
        const contextPath = "${pageContext.request.contextPath}";
        const boardId = "${boardContent != null ? boardContent.id : ''}";
    </script>
    <script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<article>
		<section class="section">
			<div class="inner">
				<div class="container" role="main">
					<div class="bg-white rounded shadow-sm" style="margin-top: 20px;">
						<div class="board_title">
							<c:out value="${boardContent.title}" />
						</div>
						<div class="board_info_box">
							<span class="board_author"><c:out
									value="${boardContent.memberName}" />,</span> <span
								class="board_date"><c:out
									value="${boardContent.createAt}" /></span>
						</div>
						<div class="board_content">
							<c:out value="${boardContent.content}" />
						</div>
						<div class="board_tag">
							TAG :
							<c:out value="${boardContent.tag}" />
						</div>
					</div>
					<div style="margin-top: 20px">
						<!-- 작성자인 경우에만 수정 및 삭제 버튼 노출 -->
						<c:if test="${member.id == boardContent.memberId}">
							<button type="button" id="btnUpdate">수정</button>
							<button type="button" id="btnDelete">삭제</button>
						</c:if>
						<button type="button" id="btnList">목록</button>
					</div>
				</div>
			</div>
		</section>
	</article>
</body>
</html>
