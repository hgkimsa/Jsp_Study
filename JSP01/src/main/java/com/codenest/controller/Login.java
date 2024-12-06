package com.codenest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codenest.model.MemberDAO;
import com.codenest.model.MemberDTO;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String google = request.getParameter("google_account");
        String pw = request.getParameter("password");

        if (google == null || google.trim().isEmpty() || pw == null || pw.trim().isEmpty()) {
            response.sendRedirect("login.jsp?error=empty");
            return;
        }

        MemberDTO dto = new MemberDTO(google, null, pw, null, null);
        MemberDAO dao = new MemberDAO();
        MemberDTO result = dao.login(dto);

        if (result != null) {
            HttpSession session = request.getSession();
            session.setAttribute("google_account", google);
            response.sendRedirect("cal.html");
            System.out.println("로그인 성공!");
        } else {
            System.out.println("로그인 실패");
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}