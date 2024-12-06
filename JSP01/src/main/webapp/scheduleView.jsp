<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>일정 보기</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            text-align: left;
            padding: 10px;
            border: 1px solid #ddd;
        }
        table th {
            background-color: #4052B5;
            color: #ffffff;
        }
        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .no-data {
            text-align: center;
            padding: 20px;
            color: #888;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>일정 보기</h1>
        
        <c:choose>
            <c:when test="${not empty scheduleList}">
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>시작 날짜</th>
                            <th>종료 날짜</th>
                            <th>메모 제목</th>
                            <th>중요도</th>
                            <th>생성일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="schedule" items="${scheduleList}">
                            <tr>
                                <td>${schedule.IDX}</td>
                                <td>${schedule.todo_startdate}</td>
                                <td>${schedule.todo_deaddate}</td>
                                <td>${schedule.todo_memo_name}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${schedule.is_important == 1}">중요</c:when>
                                        <c:otherwise>일반</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${schedule.created_at}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="no-data">표시할 일정이 없습니다.</div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>