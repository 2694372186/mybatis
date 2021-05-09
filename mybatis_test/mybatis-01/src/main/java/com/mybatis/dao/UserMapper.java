package com.mybatis.dao;

import com.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    //按id查询
    User getUser(int id);

    //分页
    List<User> getUserLimit(Map<String,Integer> map);

    @Insert("insert into user values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{},pwd=#{password} where id=#{id]")
    int updateUser(User user);

    @Delete("delete from user where id=#[id]")
    int deleteUser(@Param("id") int id);

    @Select("select * from user where id=#{id}")
    List<User> getUsers(@Param("id") int id);
}
