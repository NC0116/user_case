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

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //       1.设置编码
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        UserService service = new UserServiceImpl();
        service.deleteUser(id);
        //转接
        req.getRequestDispatcher(req.getContextPath()+"/findUserByPageServlet").forward(req,resp);
    }
}
