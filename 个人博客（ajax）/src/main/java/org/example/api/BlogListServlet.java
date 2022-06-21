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
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-19
 * Time:17:56
 */
@WebServlet("/blog/list")
public class BlogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //没有请求数据，但要根据用户查询获取文章
        resp.setCharacterEncoding("UTF-8");
        User user= WebUtil.validateLogin(req);
        //没有登录返回401
        if(user==null){
            resp.setStatus(401);
            return;
        }
        //登录。。查询文章列表
        List<Article> articles= ArticleDao.queryBlogList(user.getId());
        WebUtil.serialize(resp,articles);
    }
}
