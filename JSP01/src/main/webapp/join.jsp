<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="css/Member.css"> <!-- Link to external CSS -->
</head>
<body>

<div class="container">
    <h2>회원가입</h2>
    <form action="Join" method="post">
        <label for="google_account">구글 계정:</label>
        <input type="email" id="google_account" name="google_account" required>

        <label for="nickname">닉네임:</label>
        <input type="text" id="nickname" name="nickname" required>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required>

        <label for="address">주소:</label>
        <input type="text" id="address" name="address">

        <label for="birthday">생일:</label>
        <input type="date" id="birthday" name="birthday">

        <input type="submit" value="가입하기">
    </form>
</div>

</body>
</html>