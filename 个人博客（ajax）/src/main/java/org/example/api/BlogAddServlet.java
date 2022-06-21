package org.example.api;

import org.example.dao.ArticleDao;
import org.example.model.Article;
import org.example.model.User;
import org.example.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-21
 * Time:9:45
 */
@WebServlet("/blog/add")
public class BlogAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Article a= WebUtil.deserialize(req,Article.class);
        //获取session中的用户信息
        User user= WebUtil.validateLogin(req);
        //没有登录返回401
        if(user==null){
            resp.setStatus(401);
            return;
        }
        //登录，插入文章
        a.setUser_id(user.getId());
        int n= ArticleDao.insert(a);
        Map<String,Object> map=new HashMap<>();
        map.put("ok",true);
        WebUtil.serialize(resp,map);

    }
}
