package com.seoil.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.seoil.db.SqlSessionManager;

public class Todo_DAO {

   // 데이터베이스 접속에 대한 모든 내용을 요청하는 클래스!
   SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession(); // SqlSessionFactory 객체 가져오기
   
   public int join(Todo_DTO dto) {
      SqlSession sqlSession = sqlSessionFactory.openSession(true); // 자동 commit 기능 활성화
      
      int cnt = sqlSession.insert("join", dto); // SQL 문장 실행
      
      if(cnt > 0) {
         System.out.println("회원가입 성공");
      } else {
         System.out.println("회원가입 실패");
      }
      
      sqlSession.close(); // 연결 객체 반납
      
      return cnt; // 결과값 반환
   }
   
   public Todo_DTO login(Todo_DTO dto) {
       SqlSession sqlSession = sqlSessionFactory.openSession(); // 연결객체 빌려오기
       
       Todo_DTO result = sqlSession.selectOne("login", dto); // SQL 문장 실행
       
       sqlSession.close(); // 연결객체 반납
       
       return result; // 결과 반환
   }
   
   public List<Todo_DTO> selectAll() {
       SqlSession sqlSession = sqlSessionFactory.openSession(); // 연결객체 빌려오기
       
       List<Todo_DTO> list = sqlSession.selectList("userList"); // SQL 문장 실행
       
       sqlSession.close(); // 연결객체 반납
       
       return list; // 결과 반환
   }
   
   public int update(Todo_DTO dto) {
       SqlSession sqlSession = sqlSessionFactory.openSession(true); // 자동 commit 기능 활성화
      
       int result = sqlSession.update("update", dto); // SQL 문장 실행
      
       sqlSession.close(); // 연결객체 반납
      
       return result; // 결과 반환
   }
}