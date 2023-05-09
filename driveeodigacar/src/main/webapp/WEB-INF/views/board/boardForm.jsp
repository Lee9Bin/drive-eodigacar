<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/layout/commonHead.jsp"%>
<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
</head>

<body>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<article>
    <section class="section">
        <div class="write-container">
            <h2>게시글 작성</h2>
            <form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post"
                      action="${pageContext.request.contextPath}/board/saveBoard">
                <form:hidden path="id" />
                <form:hidden path="memberId" value="${member.id}" />
                <input type="hidden" name="mode" value="${mode}" />

                <div class="mb-3">
                    <label for="title">제목</label>
                    <form:input path="title" id="title" class="form-control" placeholder="제목을 입력해 주세요" />
                </div>

                <div class="mb-3">
                    <label for="content">내용</label>
                    <form:textarea path="content" id="content" class="form-control"
                                   placeholder="내용을 입력해 주세요"></form:textarea>
                </div>

                <div class="mb-3">
                    <label for="tag">TAG</label>
                    <form:input path="tag" id="tag" class="form-control" placeholder="태그를 입력해 주세요" />
                </div>

                <div class="form-buttons">
                    <button type="button" id="btnSave">저장</button>
                    <button type="button" id="btnList">목록</button>
                </div>
            </form:form>
        </div>
    </section>
</article>
</body>
</html>
