package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SpecialSqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Horace
 * @Date 2022/8/15 21:04
 * @Version 1.0
 */
public class SpecialSqlMapperTest {


    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }


    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUser("9,10");
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null,"xiaoming","123456",23,"男","123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }


}
