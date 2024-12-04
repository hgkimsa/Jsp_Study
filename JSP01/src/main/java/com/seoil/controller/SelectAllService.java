package com.seoil.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoil.model.Todo_DAO;
import com.seoil.model.Todo_DTO;

@WebServlet("/SelectAll")
public class SelectAllService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. DAO 생성
        Todo_DAO dao = new Todo_DAO();
        
        // 2. DAO에 있는 selectAll 메소드 사용하기
        List<Todo_DTO> list = dao.selectAll();
        
        // 3. request scope에 전체 회원정보 담아주기
        request.setAttribute("userList", list);
        
        // 4. select.jsp로 forward 방식으로 이동
        RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
        rd.forward(request, response);
    }
}