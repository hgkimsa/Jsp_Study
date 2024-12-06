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
        <div class="header-text">관리자에게 문의</div>
    </div>
    <div class="content">
        <form action="askManager" method="post">
            <div class="form-group">
                <label>제목</label>
                <input type="text" name="title">
            </div>
            <div class="form-group">
                <label>문의내용</label>
                <textarea name="memo"></textarea>
            </div>
            <div class="form-group">
                <label>파일 업로드</label>
                <input type="text" name="fileName">
            </div>
            <div class="form-group">
                <label>이메일</label>
                <input type="text" name="email">
            </div>
            <div class="button-group">
                <button type="submit">보내기</button>
                
                <a href="home">취소</a>
            </div>
            <!-- 관리자 답변이 있을 경우 표시 -->
            <%
            if(request.getAttribute("managerReply") != null) { %>
            <h2>관리자 답변</h2>
            <p>${managerReply.reply}</p>
        	<% } %>
            
            
        </form>
    </div>
    <div class="contact-button">
        문의하기
    </div>

</body>
</html>