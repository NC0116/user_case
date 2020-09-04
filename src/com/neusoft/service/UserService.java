package com.neusoft.service;


import com.neusoft.domin.PageBean;
import com.neusoft.domin.User;

import java.util.List;
import java.util.Map;

//用户管理业务接口
public interface UserService {

        //1.查询所有用户信息
        public List<User> findAll();
        //2.添加用户信息
        public int saveUser(User user);
        //3.修改用户信息
        public void updateUser(User user);
        public User findById(String id);
        //4.删除用户信息
        public void deleteUser(String id);
        //5.登录用户
        public User loginUser(User user);
        //6.list页面输入信息查询
        public  List<User> findUser(User user);
        //7.list页面选择删除
        public void   deleteSelectUser(String[] uids);
        //8.分页查询
        //分页查询每页记录
        public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
