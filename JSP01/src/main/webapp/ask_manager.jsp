<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Astro Work</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #3e50b4;
            color: white;
            padding: 35px;
            height: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .header-text {
            font-size: 2.5em;
            font-weight: bold;
        }
        .content {
            padding: 20px;
            text-align: center;
        }
        .form-group {
            margin: 20px auto;
            max-width: 600px;
            text-align: left;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #333;
            font-weight: bold;
        }
        .form-group input[type="text"],
        .form-group input[type="file"],
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 15px;
        }
        .form-group textarea {
            height: 150px;
            resize: vertical;
        }
        .button-group {
            margin-top: 20px;
            text-align: center;
        }
        .button-group button {
            background-color: #3e50b4;
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 0 5px;
            border-radius: 4px;
            cursor: pointer;
        }
        .button-group button.cancel {
            background-color: #f4f4f4;
            color: #333;
            border: 1px solid #ddd;
        }
        .contact-button {
            position: fixed;
            top: 35px;
            right: 20px;
            background-color: #fff;
            border: 2px solid #3e50b4;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="header-text">사용자 문의내용</div>
    </div>
    <div class="content">
        	<!-- 유저 문의 받아와서 타이틀, 내용, 파일 출력(메일도 받아올것) -->
        	
            <div class="form-group">
                <p>제목: ${userAsk.title}</p>
            </div>
            <div class="form-group">
                <p>내용: ${userAsk.memo}</p>
            </div>
            <div class="form-group">
                <p>파일: ${userAsk.file}</p>
            </div>
            <div class="form-group">
                <p>이메일: ${userAsk.email}</p>
            </div>
            <!-- 관리자 댓글 -->
            <div class="form-group">
                <label>관리자 답변</label>
            </div>
                
        <form action="replyUser" method="post">
            <input type="hidden" name="title" value="${userAsk.title}">
	        <input type="hidden" name="memo" value="${userAsk.memo}">
    	    <input type="hidden" name="file" value="${userAsk.file}">
        	<input type="hidden" name="email" value="${userAsk.email}">
        	답변: <textarea name="reply"></textarea><br>
            <div class="button-group">
                <button type="submit">회신하기</button>
                <a href="home">홈으로</a>
            </div>
        </form>
    </div>
    <div class="contact-button">
        문의하기
    </div>
</body>
</html>