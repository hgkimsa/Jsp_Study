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
        request.setCharacterEncoding("UTF-8");

        // Retrieve parameters from request
        String googleAccount = request.getParameter("google_account");
        String startDate = request.getParameter("todo_startdate");
        String deadDate = request.getParameter("todo_deaddate");
        String memo = request.getParameter("todo_memo");
        String filePath = request.getParameter("todo_file_path");
        int isImportant = Integer.parseInt(request.getParameter("is_important"));

        // Create a new todoDTO object
        todoDTO newTodo = new todoDTO();
        newTodo.setGoogle_account(googleAccount);
        newTodo.setTodo_startdate(startDate);
        newTodo.setTodo_deaddate(deadDate);
        newTodo.setTodo_memo(memo);
        newTodo.setTodo_file_path(filePath);
        newTodo.setIs_important(isImportant);

        // Add the todo item using DAO
        todoDAO dao = new todoDAO();
        boolean isAdded = dao.addTodo(newTodo);

        // Handle response accordingly
        if (isAdded) {
            response.sendRedirect("success.jsp"); // Redirect on success
        } else {
            response.sendRedirect("error.jsp"); // Redirect on failure
        }
    }
}