package com.codenest.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.codenest.db.SqlSessionManager;

public class todoDAO {

    // SqlSessionFactory 객체를 생성하여 데이터베이스 세션을 관리합니다.
    SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // 새로운 todo 항목을 추가하는 메소드
    public boolean addTodo(todoDTO todo) {
        // 데이터베이스 세션을 오픈합니다. true는 자동 커밋을 의미합니다.
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            // MyBatis를 사용하여 todo 항목을 데이터베이스에 삽입합니다.
            int rowsAffected = sqlSession.insert("com.codenest.db.TodoMapper.addTodo", todo);
            // 삽입된 행의 수가 0보다 크면 true를 반환합니다.
            return rowsAffected > 0; 
        } finally {
            // 세션을 닫아 리소스를 해제합니다.
            sqlSession.close();
        }
    }

    // 모든 todo 항목을 가져오는 메소드
    public ArrayList<todoDTO> getAllTodos() {
        // 데이터베이스 세션을 오픈합니다. true는 자동 커밋을 의미합니다.
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<todoDTO> list = null;
        
        try {
            // MyBatis를 사용하여 모든 todo 항목을 조회합니다.
            list = sqlSession.selectList("com.codenest.db.TodoMapper.getAllTodos");
        } finally {
            // 세션을 닫아 리소스를 해제합니다.
            sqlSession.close();
        }
        
        // 조회된 리스트를 ArrayList로 변환하여 반환합니다.
        return new ArrayList<>(list);
    }
}