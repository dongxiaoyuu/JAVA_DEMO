package org.example.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-21
 * Time:11:31
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注销功能
        resp.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        //重定向到登录页面
        resp.sendRedirect("login.html");
    }
}
