package org.example.dao;

import com.mysql.jdbc.Statement;
import org.example.model.Article;
import org.example.util.DButil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-19
 * Time:18:00
 */
public class ArticleDao {
    //根据用户查询关联的文章内容
    public static List<Article> queryBlogList(Integer userId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            c = DButil.getConnection();
            String sql = "select *from article where user_id=?";
            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            //替换占位符
            ps.setInt(1, userId);
            //3执行sql
            rs = ps.executeQuery();
            //4处理结果集
            List<Article> articles = new ArrayList<>();
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                java.sql.Timestamp createtime = rs.getTimestamp("create_time");
                a.setCreateTime(new java.util.Date(createtime.getTime()));
                a.setUser_id(userId);
                articles.add(a);

            }
            return articles;
        } catch (Exception e) {
            throw new RuntimeException("查询模块列表出错", e);
        } finally {
            DButil.close((com.mysql.jdbc.Connection) c, (Statement) ps, rs);
        }
    }

    public static Article queryBlogDetail(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            c = DButil.getConnection();
            String sql = "select *from article where id=?";
            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            //替换占位符
            ps.setInt(1, id);
            //3执行sql
            rs = ps.executeQuery();
            //4处理结果集

            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                java.sql.Timestamp createtime = rs.getTimestamp("create_time");
                a.setCreateTime(new java.util.Date(createtime.getTime()));
                a.setUser_id(rs.getInt("user_id"));
                return a;

            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("查询模块详情出错", e);
        } finally {
            DButil.close((com.mysql.jdbc.Connection) c, (Statement) ps, rs);
        }
    }

    public static int insert(Article a) {
        Connection c=null;
        PreparedStatement ps=null;
        try {
            //1.获取连接
            c=DButil.getConnection();
            String sql="insert into article(title,content,user_id) values(?,?,?)";
            //2.创建操作命令对象
            ps=c.prepareStatement(sql);
            //3.替换占位符
            ps.setString(1, a.getTitle());
            ps.setString(2, a.getContent());
            ps.setInt(3, a.getUser_id());
            return ps.executeUpdate();
        }catch (Exception e){
            throw  new RuntimeException("发布文章失败",e);
        }finally {
            DButil.close((com.mysql.jdbc.Connection) c, (Statement) ps);
        }
    }
    @Test
    public void testInset(){
        Article a=new Article();
        a.setTitle("单元测试-标题");
        a.setContent("test-content");
        a.setUser_id(1);
        int n=insert(a);
        Assert.assertTrue(n==1);
    }

    @Test
    public void testQueryBlogList(){
        List<Article> articles=queryBlogList(1);
        System.out.println(articles);
        Assert.assertTrue(articles.size()==3);
    }
    @Test
    public void testQueryBlogDetail(){
        Article a=queryBlogDetail(1);
        System.out.println(a);

    }
}

