package com.neusoft.webServlet;


import com.neusoft.domin.User;
import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       1.调用 完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

//        User user = new User();
//        String name = req.getParameter("name");
//        String gender = req.getParameter("gender");
//        Integer age = Integer.parseInt(req.getParameter("age"));
//        String address = req.getParameter("address");
//        String qq = req.getParameter("qq");
//        String email = req.getParameter("email");
//        user.setName(name);
//        user.setGender(gender);
//        user.setAge(age);
//        user.setAddress(address);
//        user.setQq(qq);
//        user.setEmail(email);
//        int count = service.saveUser(user);
//        System.out.println(count);


        //2.将数据存入req中
        req.setAttribute("users",users);
        //3.转发到list.jsp页面中
        req.getRequestDispatcher("/list.jsp").forward(req,resp);


    }
}
