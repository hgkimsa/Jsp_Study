package com.codenest.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.codenest.db.SqlSessionManager;

public class MemberDAO {
    // SqlSessionFactory 객체를 SqlSessionManager로부터 가져옴
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 회원 가입 메서드
    public int join(MemberDTO dto) {
        // try-with-resources 문을 사용하여 자동으로 리소스를 관리
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 자동 커밋 모드로 세션 열기
            // MemberMapper의 join 쿼리를 실행하고 결과를 cnt에 저장
            int cnt = sqlSession.insert("com.codenest.db.MemberMapper.join", dto);
            if (cnt > 0) { // 회원가입 성공 시
                System.out.println("회원가입 성공");
            } else { // 회원가입 실패 시
                System.out.println("회원가입 실패");
            }
            return cnt; // 결과 반환 (성공 시 삽입된 행 수)
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            return 0; // 예외 발생 시 0 반환
        }
    }

    // 로그인 메서드
    public MemberDTO login(MemberDTO dto) {
        try (SqlSession session = sqlSessionFactory.openSession()) { // 자동 커밋이 아닌 일반 세션 열기
            // MemberMapper의 login 쿼리를 실행하고 결과를 반환
            return session.selectOne("com.codenest.db.MemberMapper.login", dto);
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            return null; // 로그인 실패 시 null 반환
        }
    }

    // 회원정보 수정 메서드
    public int update(MemberDTO dto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) { // 자동 커밋 모드로 세션 열기
            // MemberMapper의 update 쿼리를 실행하고 결과를 result에 저장
            int result = sqlSession.update("com.codenest.db.MemberMapper.update", dto);
            return result; // 결과 반환 (수정된 행 수)
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            return 0; // 예외 발생 시 0 반환
        }
    }
}