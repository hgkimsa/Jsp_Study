<%@page import="com.seoil.model.Todo_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>회원 관리 페이지</title>
    <meta charset="UTF-8" />
</head>
<body style="text-align: center;">
    <div id="wrapper">
        <nav id="Update">    
            <table>
                <caption><h2>회원관리페이지</h2></caption>
                <tr>
                    <td>IDX</td>
                    <td>TODO_STARTDATE</td>
                    <td>TODO_DEADDATE</td>
                    <td>TODO_MEMO</td>
                    <td>TODO_FILE_PATH</td>
                    <td>IS_IMPORTANT</td>
                    <td>CREATED_AT</td>                            
                </tr>

                <% 
                List<Todo_DTO> list = (List<Todo_DTO>)request.getAttribute("userList");
                if (list != null) { // list가 null이 아닐 때만 반복문 실행
                    for(Todo_DTO member : list) { 
                %>
                    <tr>
                        <td><%= member.getIDX() %></td>
                        <td><%= member.getTodo_startdate() %></td>
                        <td><%= member.getTodo_deaddate() %></td>
                        <td><%= member.getTodo_memo() %></td>
                        <td><%= member.getTodo_file_path() %></td>
                        <td><%= member.getIs_important() %></td>
                        <td><%= member.getCreated_at() %></td>
                    </tr>
                <% 
                    } 
                } else { // list가 null인 경우
                %>
                    <tr>
                        <td colspan="7">회원 정보가 없습니다.</td> <!-- 회원 정보가 없을 때 메시지 표시 -->
                    </tr>
                <% 
                } 
                %>
            </table>
        </nav>        
        <a href="main.jsp" class="button next scrolly">되돌아가기</a>    
    </div>

   
</body>
</html>