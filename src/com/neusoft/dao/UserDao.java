package com.neusoft.dao;

import com.neusoft.domin.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //1.用户操作dao,查询用户列表

    public List<User> findAll();
    //2.添加用户信息
    public int saveUser(User user);

    //3.修改用户信息
    public void updateUser(User user);
    public User findById(int id);

    //4.删除用户
    public void deleteUser(int id);

    //5.登录用户
    public User loginUser(User user);

    //6.list页面输入信息查询
    public List<User> findUser(User user);

    //7.分页查询
    // 查询总记录数
    public int findTotalCount( Map<String,String[]> condition);
    //分页查询每页记录
    public List<User> findByPage(int start, int rows, Map<String,String[]> condition);
}
