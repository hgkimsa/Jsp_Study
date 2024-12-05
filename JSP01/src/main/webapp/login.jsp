<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.codenest.model.MemberDAO" %>
<%@ page import="com.codenest.model.MemberDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" type="text/css" href="css/Member.css">
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">   
</head>
<body>

<div class="container">
    <% 
        // 세션에서 사용자 정보를 가져오기
        HttpSession userSession = request.getSession();
        String googleAccount = (String) userSession.getAttribute("google_account");
        
        if (googleAccount != null) {
            // 로그인 성공 시 환영 메시지 및 버튼 표시
    %>
            <h2>환영합니다, <%= googleAccount %>님!</h2>
            <!-- 정보 수정 및 로그아웃 버튼 추가 -->
            <form method="post">
                <button type="button" class="w3-button w3-orange" onclick="location.href='update.jsp';">정보 수정</button>
                <input type="submit" class="w3-button w3-red" name="logoutButton" value="로그아웃">
            </form>

    <% 
            // 로그아웃 처리
            if (request.getMethod().equalsIgnoreCase("post") && request.getParameter("logoutButton") != null) {
                userSession.invalidate(); // 세션 무효화
                out.println("<script>alert('로그아웃 되었습니다.'); location.href='login.jsp';</script>");
            }
        } else {
            // 로그인 폼 및 회원가입 버튼 표시
    %>
            <h2>로그인</h2>
            <form action="Login" method="post">
                <label for="google_account">구글 계정:</label>
                <input type="email" id="google_account" name="google_account" required>

                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password" required>

                <div class="w3-clear"></div> <!-- Clear floats -->
                <input type="submit" class="w3-button w3-green" value="로그인">
               
                <!-- 회원가입 버튼 추가 -->
                <button type="button" class="w3-button w3-green" onclick="location.href='join.jsp'" style="margin-left: 10px;">
                회원가입</button>
            </form>
    <% 
        }
    %>
	
</div>

</body>
</html>