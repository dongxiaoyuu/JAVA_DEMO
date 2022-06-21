package org.example.api;

import org.example.dao.ArticleDao;
import org.example.model.Article;
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
 * Time:20:01
 */
@WebServlet("/blog/detail")
public class BlogDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String id=req.getParameter("id");
        Article a= ArticleDao.queryBlogDetail(Integer.parseInt(id));
        WebUtil.serialize(resp,a);
    }
}
