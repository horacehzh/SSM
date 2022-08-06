package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Horace
 * @Date 2022/8/6 16:01
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void testInsert() throws IOException {
        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSession对象 创建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取Sql的绘画对象 SqlSession，是mybatis提供的操作数据库的对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取Sql的绘画对象 SqlSession(true)，会自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取UserMapper的代理实现类对象
        // 由于Mapper接口无法创建对象，所以使用代理模式生成mapper接口的代理实现类
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        // 调用mapper接口中的方法，实现添加用户信息的功能
//        int result = mapper.insertUser();

        // 提供sql以及的唯一标识找到sql并执行，唯一标识是namespace.sqlId
        int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");
        System.out.println("结果："+result);
        // 提交事务
//        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();


    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

}
