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

@WebServlet("/Join")
public class JoinService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정

        // 요청 파라미터 가져오기
        String google = request.getParameter("google_account"); // 구글 계정
        String nick = request.getParameter("nickname"); // 닉네임
        String pw = request.getParameter("password"); // 비밀번호
        String address = request.getParameter("address"); // 주소
        String birth = request.getParameter("birthday"); // 생일

        // 입력 검증
        if (isInputValid(google, nick, pw, address, birth)) { // 입력 값이 유효한지 확인
            // MemberDTO 객체 생성 및 데이터 설정
            MemberDTO dto = new MemberDTO(google, nick, pw, address, birth);
            
            // DAO를 통해 회원가입 처리
            MemberDAO dao = new MemberDAO();
            int result = dao.join(dto); // 회원가입 메서드 호출

            // 결과에 따라 리다이렉트
            if (result > 0) { // 회원가입 성공 시
                HttpSession session = request.getSession(); // 세션 생성
                session.setAttribute("google", google); // 세션에 구글 계정 저장
                response.sendRedirect("login.jsp"); // 회원가입 성공 후 로그인 페이지로 리다이렉트
            } else { // 회원가입 실패 시
                response.sendRedirect("join.jsp"); // 다시 가입 페이지로 리다이렉트
            }
        } else { // 입력 값이 유효하지 않은 경우
            response.sendRedirect("join.jsp?error=invalid_input"); // 에러 메시지를 쿼리 파라미터로 전달하여 가입 페이지로 리다이렉트
        }
    }

    // 입력 검증 메서드
    private boolean isInputValid(String google, String nick, String pw, String address, String birth) {
        return google != null && !google.trim().isEmpty() && // 구글 계정이 null이 아니고 비어있지 않은지 확인
               nick != null && !nick.trim().isEmpty() && // 닉네임이 null이 아니고 비어있지 않은지 확인
               pw != null && !pw.trim().isEmpty() && // 비밀번호가 null이 아니고 비어있지 않은지 확인
               address != null && !address.trim().isEmpty() && // 주소가 null이 아니고 비어있지 않은지 확인
               birth != null && !birth.trim().isEmpty(); // 생일이 null이 아니고 비어있지 않은지 확인
    }
}