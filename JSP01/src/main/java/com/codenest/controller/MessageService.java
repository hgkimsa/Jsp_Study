package com.codenest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codenest.model.todoDAO;
import com.codenest.model.todoDTO;

@WebServlet("/MessageService")
public class MessageService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        
        // 2. 요청에서 파라미터를 가져옵니다.
        String google_account = request.getParameter("google_account");
        String startdate = request.getParameter("todo_startdate");
        String deaddate = request.getParameter("todo_deaddate");
        String memo = request.getParameter("todo_memo");
        String file = request.getParameter("todo_FILE_PATH");
        
        // 3. 데이터 처리하기 -> DB 전달
        todoDTO dto = new todoDTO();
        dto.setGoogle_account(google_account); // 구글 계정 설정
        dto.setTodo_startdate(startdate);       // 시작일 설정
        dto.setTodo_deaddate(deaddate);         // 마감일 설정
        dto.setTodo_memo(memo);                 // 메모 설정
        dto.setTodo_file_path(file);            // 파일 경로 설정
        
        // 4. 결과에 따른 화면 출력 작업
        RequestDispatcher rd = request.getRequestDispatcher("Message.jsp"); // Message.jsp로 포워드
        rd.forward(request, response); // 요청과 응답을 포워드하여 다음 페이지로 이동
    }
}