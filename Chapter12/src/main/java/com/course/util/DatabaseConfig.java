package com.course.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 工具类一般使用静态资源，可以直接获取
 */
public class DatabaseConfig {

    public static SqlSession getSqlsession() throws IOException {
        //获取配置的资源文件
        Reader reader=Resources.getResourceAsReader("databaseconfig.xml");

        //把这个文件给build出来 相当于使用配置文件把他加载出来
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //sqlSession就是能够执行配置文件中的sql语句。
        SqlSession sqlSession = factory.openSession();

        return sqlSession;

    }

}
