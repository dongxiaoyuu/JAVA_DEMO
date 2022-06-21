package org.example.api;

import org.example.model.User;
import org.example.dao.UserDao;
import org.example.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-18
 * Time:10:19
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求

        resp.setCharacterEncoding("UTF-8");
        //json转Java对象
        User user= WebUtil.deserialize(req, User.class);
        //构造一个返回数据
        Map<String,Object> body=new HashMap<>();
        //验证账号密码
        User query= UserDao.queryByUsername(user.getUsername());

        if(query==null){

            body.put("ok",false);
            body.put("error","账号不存在");

        }else if(!query.getPassword().equals(user.getPassword())){
            body.put("ok",false);
            body.put("error","账号或密码错误");
        }else {
            body.put("ok", true);
            //登录成功，创建session
            HttpSession session = req.getSession();

            session.setAttribute("user", query);
        }
        WebUtil.serialize(resp,body);
    }
}
