<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.codenest.model.todoDAO"%>
<%@ page import="com.codenest.model.todoDTO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
    <%
        todoDAO dao = new todoDAO();
        ArrayList<todoDTO> list = dao.getAllTodos(); // 모든 todo 항목을 가져오는 메소드
        
        if(list != null && !list.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>계정</th>
                <th>시작일</th>
                <th>끝난일</th>
                <th>메모</th>
                <th>파일 경로</th>
                <th>중요도</th>
                <th>생성일</th>
            </tr>
            <% for(todoDTO todo : list) { %>
                <tr>
                    <td><%= todo.getIdx() %></td>
                    <td><%= todo.getGoogle_account() %></td>
                    <td><%= todo.getTodo_startdate() %></td>
                    <td><%= todo.getTodo_deaddate() %></td>
                    <td><%= todo.getTodo_memo() %></td>
                    <td><%= todo.getTodo_file_path() %></td>
                    <td><%= todo.getIs_important() %></td>
                    <td><%= todo.getCreated_at() %></td>
                </tr>
            <% } %>
        </table>
    <%
        } else {
            out.println("데이터가 없습니다.");
        }
    %>
</body>
</html>