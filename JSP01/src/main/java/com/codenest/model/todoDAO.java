package com.codenest.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.codenest.db.SqlSessionManager;

public class todoDAO {

    SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
    
    
    // 모든 todo 항목을 가져오는 메소드
    public ArrayList<todoDTO> getAllTodos() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<todoDTO> list = null;
        
        try {
            list = sqlSession.selectList("getAllTodos");
        } finally {
            sqlSession.close();
        }
        
        return new ArrayList<>(list);
    }
    
    // 특정 사용자의 todo 항목을 가져오는 메소드 (기존 login 메소드)
    public ArrayList<todoDTO> getTodosByAccount(String google_account) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<todoDTO> list = null;
        
        try {
            list = sqlSession.selectList("getTodosByAccount", google_account);
        } finally {
            sqlSession.close();
        }
        
        return new ArrayList<>(list);
    }
}