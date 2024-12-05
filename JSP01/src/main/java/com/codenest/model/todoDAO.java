package com.codenest.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.codenest.db.SqlSessionManager;

public class todoDAO {
    
    SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

    // Method to add a new todo item
    public boolean addTodo(todoDTO todo) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            int rowsAffected = sqlSession.insert("com.codenest.db.TodoMapper.addTodo", todo);
            return rowsAffected > 0; // Return true if at least one row was inserted
        } finally {
            sqlSession.close();
        }
    }

    // Method to get all todos
    public ArrayList<todoDTO> getAllTodos() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<todoDTO> list = null;
        
        try {
            list = sqlSession.selectList("com.codenest.db.TodoMapper.getAllTodos");
        } finally {
            sqlSession.close();
        }
        
        return new ArrayList<>(list);
    }
}