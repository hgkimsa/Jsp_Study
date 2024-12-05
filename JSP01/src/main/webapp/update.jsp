<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.codenest.model.MemberDAO" %>
<%@ page import="com.codenest.model.MemberDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <link rel="stylesheet" type="text/css" href="css/Member.css">
</head>
<body>

<%
    // 세션에서 사용자 정보를 가져오기
    HttpSession update = request.getSession();
    String googleAccount = (String) session.getAttribute("google_account");
    
    if (googleAccount == null) {
        // 로그인하지 않은 경우 로그인 페이지로 리다이렉트
        out.print("<script>alert('로그인 후 이용하세요.'); location.href='login.jsp';</script>");
        return; // 페이지 렌더링 중단
    }
%>

<div class="container">
    <h2>회원 정보 수정</h2>
    <form method="post" action="UpdateService">
        <input type="hidden" name="google_account" value="<%= googleAccount %>">
        
        <label for="current_password">현재 비밀번호:</label><br>
        <input type="password" id="current_password" name="current_password" required><br>

        <label for="new_password">새 비밀번호:</label><br>
        <input type="password" id="new_password" name="new_password"><br>

        <label for="address">새 주소:</label><br>
        <input type="text" id="address" name="address"><br>

        <input type="submit" value="수정하기">
    </form>
</div>

</body>
</html>