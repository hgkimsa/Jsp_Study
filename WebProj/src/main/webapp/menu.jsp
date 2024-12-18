<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String sessionId = (String) session.getAttribute("sessionId");
%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/welcome.jsp'/>">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${empty sessionId}">
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/member/loginMember.jsp'/>">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/member/addMember.jsp'/>">회원 가입</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><span class="nav-link text-light">[<%=sessionId%>님]</span></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/member/logoutMember.jsp'/>">로그아웃</a></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/member/updateMember.jsp'/>">회원 수정</a></li>
                    </c:otherwise>
                </c:choose>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/products.jsp'/>">상품 목록</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/addProduct.jsp'/>">상품 등록</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/editProduct.jsp?edit=update'/>">상품 수정</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/editProduct.jsp?edit=delete'/>">상품 삭제</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/BoardListAction.do?pageNum=1'/>">게시판</a></li>
            </ul>
        </div>
    </div>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
