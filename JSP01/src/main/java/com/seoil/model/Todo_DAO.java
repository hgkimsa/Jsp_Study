package com.seoil.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.seoil.db.SqlSessionManager;

public class Todo_DAO {

   // 데이터베이스 접속에 대한 모든 내용을 요청하는 클래스!
   // 1. DB 연결
   SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
   
   public int join(Todo_DTO dto) {
      // 회원 가입을 처리할 수 있는 DB 작업을 연결하는 메소드!
      
      // DB작업을 하기 위한 기능을 대여해 오는 역할!
      // true : 자동 commit 기능!
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
   
      // sqlSession.commit();
      // sqlSession.rollback();
      
      // 2. SQL 문장 실행
      // 3. 결과값을 받기
      int cnt = sqlSession.insert("join", dto);
      
      // 4. 처리 => 리턴/리턴X
      if(cnt > 0) {
         System.out.println("회원가입 성공");
      } else {
         System.out.println("회원가입 실패");
      }
   
      // sql 기능 반납!      
      sqlSession.close();
      
      return cnt; // servlet으로 DB의 결과값을 전달!
   }
   
   // 로그인 메소드
   public Todo_DTO login(Todo_DTO dto) {
	   // 1. 연결객체(sqlSession, connection)를 빌려오기
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   
	   // 2. 연결객체를 사용해서 sql구문을 실행
	   // sql구문 : Mapper.xml 파일에 있다!
	   Todo_DTO result = sqlSession.selectOne("login", dto);
	   
	   // 3. 연결객체 반납!
	   sqlSession.close();
	   
	   return result;
   }
   
   // 전체 회원 조회하는 메소드 selectAll
   public List<Todo_DTO> selectAll() {
	// 1. 연결객체(sqlSession, connection)를 빌려오기
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   
	   // 2. 연결객체를 사용해서 sql구문을 실행
	   // sql구문 : Mapper.xml 파일에 있다!
	   List<Todo_DTO> list = sqlSession.selectList("userList");
	   
	   // 3. 연결객체 반납!
	   sqlSession.close();
	   
	   return list;
   }
   
// 회원정보를 수정하는 메소드 update
   public int update(Todo_DTO dto) {
	   // 1. 연결객체(sqlSession, connection)를 빌려오기
	   SqlSession sqlSession = sqlSessionFactory.openSession(true);
	   // 
	   
	   // 2. 연결객체를 사용해서 sql구문을 실행
	   // sql구문 : Mapper.xml 파일에 있다!
	   int result = sqlSession.update("update", dto);
	   
	   // 3. 연결객체 반납!
	   sqlSession.close();
	   
	   return result;
   }
}
