package com.codenest.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정

        String google = request.getParameter("google_account"); // 구글 계정
        String pw = request.getParameter("password"); // 비밀번호

        // 입력 검증
        if (google == null || google.trim().isEmpty() || pw == null || pw.trim().isEmpty()) {
            request.setAttribute("errorMessage", "아이디와 비밀번호를 입력하세요."); // 에러 메시지 설정
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // 로그인 페이지로 포워드하기 위한 RequestDispatcher 생성
            rd.forward(request, response); // 로그인 페이지로 포워드
            return; // 메서드 종료
        }

        // MemberDTO 객체 생성 (닉네임 등은 null로 설정)
        MemberDTO dto = new MemberDTO(google, null, pw, null, null); 

        MemberDAO dao = new MemberDAO(); // DAO 객체 생성
        MemberDTO result = dao.login(dto); // 로그인 처리

        if (result != null) { // 로그인 성공 시
            HttpSession session = request.getSession(); // 세션 생성
            session.setAttribute("google_account", google); // 구글 계정을 세션에 저장
            request.setAttribute("successMessage", "로그인 성공!"); // 성공 메시지 추가
            response.sendRedirect("update.jsp"); // 로그인 성공 후 홈 페이지로 리다이렉트
            System.out.println("로그인 성공!"); // 콘솔에 로그인 성공 메시지 출력
        } else { // 로그인 실패 시
            System.out.println("로그인 실패"); // 콘솔에 로그인 실패 메시지 출력
            request.setAttribute("errorMessage", "아이디와 비밀번호를 확인하세요."); // 실패 메시지 추가
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // 로그인 페이지로 포워드하기 위한 RequestDispatcher 생성
            rd.forward(request, response); // 로그인 페이지로 포워드
        }
    }
}