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

@WebServlet("/UpdateService")
public class updateService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 세션에서 구글 계정 가져오기
        HttpSession session = request.getSession();
        String googleAccount = (String) session.getAttribute("google_account");
        
        // 로그인 확인
        if (googleAccount == null) {
            response.sendRedirect("login.jsp"); // 로그인 페이지로 리다이렉트
            return; // 메서드 종료
        }

        // 폼 데이터 가져오기
        String currentPassword = request.getParameter("current_password");
        String newPassword = request.getParameter("new_password");
        String address = request.getParameter("address");

        // MemberDTO 객체 생성 및 데이터 설정
        MemberDTO member = new MemberDTO();
        member.setGoogle_account(googleAccount);
        member.setPassword(currentPassword); // 현재 비밀번호로 확인
        member.setAddress(address);

        // DAO를 통해 회원정보 수정 처리
        MemberDAO dao = new MemberDAO();
        
        // 비밀번호가 변경되었는지 확인하고 업데이트 수행
        boolean isPasswordChanged = newPassword != null && !newPassword.trim().isEmpty();
        
        if (isPasswordChanged) {
            member.setPassword(newPassword); // 새 비밀번호 설정
        }

        int result = dao.update(member); // update 메서드 호출

        // 결과 메시지 출력 및 리다이렉트
        if (result > 0) {
            response.sendRedirect("login.jsp"); // 성공 페이지로 리다이렉트
        } else {
            response.sendRedirect("update.jsp"); 
            // 실패 시 다시 업데이트 페이지로 리다이렉트
        }
    }
}