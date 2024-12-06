package com.codenest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codenest.model.todoDAO;
import com.codenest.model.todoDTO;

@WebServlet("/AddTodo")
public class AddTodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정

        // 요청에서 파라미터를 가져옵니다.
        String googleAccount = request.getParameter("google_account");
        String startDate = request.getParameter("todo_startdate");
        String deadDate = request.getParameter("todo_deaddate");
        String memo = request.getParameter("todo_memo");
        String filePath = request.getParameter("todo_file_path");
        int isImportant = Integer.parseInt(request.getParameter("is_important")); // 중요도 값을 정수로 변환

        // 새로운 todoDTO 객체를 생성합니다.
        todoDTO newTodo = new todoDTO();
        newTodo.setGoogle_account(googleAccount);
        newTodo.setTodo_startdate(startDate);
        newTodo.setTodo_deaddate(deadDate);
        newTodo.setTodo_memo(memo);
        newTodo.setTodo_file_path(filePath);
        newTodo.setIs_important(isImportant);

        // DAO를 사용하여 todo 항목을 추가합니다.
        todoDAO dao = new todoDAO();
        boolean isAdded = dao.addTodo(newTodo);

        // 결과에 따라 응답을 처리합니다.
        if (isAdded) {
            response.sendRedirect("Message.jsp"); // 성공 시 Message.jsp로 리다이렉트
        } else {
            response.sendRedirect("todo.jsp"); // 실패 시 todo.jsp로 리다이렉트
        }
    }
}