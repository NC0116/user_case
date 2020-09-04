package com.neusoft.webServlet;

import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取所有选中的  uid
        String[] uids = req.getParameterValues("uid");

        UserService service = new UserServiceImpl();
//        String id = Arrays.toString(uids);
        service.deleteSelectUser(uids);

//        System.out.println();
//        System.out.println("dsd");
        resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
    }
}
