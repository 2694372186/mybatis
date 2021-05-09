package com.mybatis.dao;

import com.mybatis.model.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void select(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.info("成功进入！");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUser(1));

        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info--进入log4j");
        logger.debug("debug--进入log4j");
        logger.error("error--进入log4j");
    }

    @Test
    public void userLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> list = userMapper.getUserLimit(map);
        for(User u:list){
            System.out.println(u);
        }
        sqlSession.close();
    }
}
