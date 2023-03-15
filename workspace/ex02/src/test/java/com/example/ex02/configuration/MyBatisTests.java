package com.example.ex02.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class MyBatisTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void datasourceTest(){
        try(Connection connection = dataSource.getConnection()){
            log.info(connection.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sqlSessionFactoryTest(){
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession(true);
                Connection connection = sqlSession.getConnection();
        ){
            log.info(connection.toString());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
