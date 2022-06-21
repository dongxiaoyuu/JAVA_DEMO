package org.example.api;

import org.example.model.User;
import org.example.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-19
 * Time:17:04
 */
@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证session
        User user=WebUtil.validateLogin(req);
        //没登陆，不允许访问
        if(user==null){
            resp.setStatus(401);
            return;
        }
        //已经登录，返回用户信息
        WebUtil.serialize(resp,user);
    }
}
