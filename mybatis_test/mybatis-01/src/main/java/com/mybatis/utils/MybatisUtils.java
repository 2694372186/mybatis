package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory ---> sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        //从 XML 文件中构建 SqlSessionFactory

        //使用mybatis第一步:获取SqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession
    // 既然有了 SqlSessionFactory，顾名思义，我们就可以从中获得 SqlSession 的实例
    //SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}
