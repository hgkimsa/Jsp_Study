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
        HttpSession userSession = request.getSession();
        String googleAccount = (String) userSession.getAttribute("google_account");
        
        if (googleAccount != null) {
            response.sendRedirect("cal.html");
        } else {
    %>
            <h2>로그인</h2>
            <% 
                String error = request.getParameter("error");
                if (error != null) {
                    if (error.equals("empty")) {
                        out.println("<p style='color: red;'>아이디와 비밀번호를 입력하세요.</p>");
                    } else if (error.equals("invalid")) {
                        out.println("<p style='color: red;'>아이디와 비밀번호를 확인하세요.</p>");
                    }
                }
            %>
            <form action="Login" method="post">
                <label for="google_account">구글 계정:</label>
                <input type="email" id="google_account" name="google_account" required>

                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password" required>

                <div class="w3-clear"></div>
                <input type="submit" class="w3-button w3-green" value="로그인">
            </form>
    <% 
        }
    %>
</div>

</body>
</html>