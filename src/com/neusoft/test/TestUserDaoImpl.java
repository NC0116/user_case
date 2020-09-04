package com.neusoft.test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domin.User;
import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class TestUserDaoImpl {
    //1.测试查询列表
    @Test
    public void test1() {
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //2.测试添加
    @Test
    public void test2(){
        User user = new User();
        user.setName("王麻子");
        user.setGender("男");
        user.setAge(12);
        user.setAddress("葫芦岛");
        user.setQq("123");
        user.setEmail("123@qq.com");
        UserDao dao = new UserDaoImpl();
        int count= dao.saveUser(user);
        System.out.println(count);
    }

    @Test
    public void test3() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setId(16);
        user.setName("王麻子");
        user.setGender("男");
        user.setAge(12);
        user.setAddress("葫芦岛");
        user.setQq("123");
        user.setEmail("123@qq.com");
        UserDao dao = new UserDaoImpl();
        dao.updateUser(user);

    }
    @Test
    public void test4() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setUsername("eric");
        user.setPassword("123");
        UserDao dao = new UserDaoImpl();
        User users1= dao.loginUser(user);
        System.out.println(users1);

    }
    @Test
    public void test5() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setName("九把刀");
//        UserDao dao = new UserDaoImpl();
        UserService service = new UserServiceImpl();
        List<User> find= service.findUser(user);
        System.out.println(find);
    }
}
