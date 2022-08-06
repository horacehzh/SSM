package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @Author Horace
 * @Date 2022/8/6 15:47
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();


    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     * @return
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();


}
