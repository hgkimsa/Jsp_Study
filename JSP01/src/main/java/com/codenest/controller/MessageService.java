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
		// 1. 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		
		String google_account = request.getParameter("google_account");
		String startdate = request.getParameter("todo_startdate");
		String deaddate = request.getParameter("todo_deaddate");
		String memo = request.getParameter("todo_memo");
		String file = request.getParameter("todo_FILE_PATH");
		String created_at = request.getParameter("created_at");
		
		// 3. 데이터 처리하기 -> DB 전달
		todoDTO dto = new todoDTO();
		dto.setGoogle_account(google_account);
		dto.setTodo_startdate(startdate);
		dto.setTodo_deaddate(deaddate);
		dto.setTodo_memo(memo);
		dto.setTodo_file_path(file);
		dto.setCreated_at(created_at);
		
		// 4. 결과에 따른 화면 출력 작업
		RequestDispatcher rd = request.getRequestDispatcher("Message.jsp");
		rd.forward(request, response);
	}

}
