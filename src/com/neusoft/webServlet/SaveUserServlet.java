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

@WebServlet("/saveUserServlet")
public class SaveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("UTF-8");

        //2.获取参数
        String name = req.getParameter("name");
        String gender = req.getParameter("sex");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");

//        3.封装成对象
        User user = new User();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        user.setAddress(address);
        user.setQq(qq);
        user.setEmail(email);

//        BeanUtils.populate(user,);

//        4.调用service add 方法
        UserService service = new UserServiceImpl();
        int count= service.saveUser(user);
//        5.判断
        if (count>0){
            req.getRequestDispatcher(req.getContextPath()+"/findUserByPageServlet").forward(req,resp);
//            resp.sendRedirect(req.getContextPath()+"/userListServlet");
        }
    }
}
