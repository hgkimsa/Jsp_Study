package com.seoil.db;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
    static SqlSessionFactory sqlSessionFactory; // SqlSessionFactory 객체를 정적 변수로 선언

    // 초기화 블럭
    static {    
        try {
            String resource = "com/seoil/db/mybatis-config.xml"; // MyBatis 설정 파일 경로
            InputStream inputStream = Resources.getResourceAsStream(resource); // 설정 파일을 InputStream으로 읽어옴
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // SqlSessionFactory 객체 생성
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
        }        
    }

    // 다른 클래스에서 해당하는 sqlSessionFactory를 호출할 수 있는 메소드 생성
    public static SqlSessionFactory getSqlSession() {
        return sqlSessionFactory; // SqlSessionFactory 객체를 반환하는 메소드
    }
}