package com.neusoft.service.Impl;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domin.PageBean;
import com.neusoft.domin.User;
import com.neusoft.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao
        return dao.findAll();
    }

    @Override
    public int saveUser(User user) {
        return dao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
         dao.updateUser(user);
    }

    @Override
    public User findById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User loginUser(User user) {
        return dao.loginUser(user);
    }

    @Override
    public  List<User> findUser(User user) {

        return dao.findUser(user);
    }

    @Override
    public  void deleteSelectUser(String[] uids) {
        for (String uid:uids) {
            int id = Integer.parseInt(uid);
            dao.deleteUser(id);
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0){
            currentPage = 1;
        }
        // 创建 PageBean对象
        PageBean<User> pb = new PageBean();
        // 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 调用dao 的 查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 调用 dao 分页查询
        int start = (currentPage-1)*rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        // 计算总页码
        int totalPage = (totalCount%rows) == 0? totalCount/rows : totalCount/rows +1;
        pb.setTotalPage(totalPage);

        return pb;
    }


}
