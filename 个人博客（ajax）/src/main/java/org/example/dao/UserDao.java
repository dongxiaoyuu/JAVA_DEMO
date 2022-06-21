package org.example.dao;

import org.example.model.User;
import org.example.util.DButil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-18
 * Time:10:38
 */
public class UserDao {
    public static User queryByUsername(String username){
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            //1创建数据库连接
            c= DButil.getConnection();
            String sql="select * from user where username=?";
            //2创建命令对象
            ps=c.prepareStatement(sql);
            //替换占位符：第一个参数是占位符索引
            ps.setString(1,username);
            //3执行sql
            rs=ps.executeQuery();
            //4处理结果集
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setHead(rs.getString("head"));
                user.setGithub(rs.getString("github"));
                return user;
            }
            return null;
        }catch (SQLException e) {
            throw new RuntimeException("根据账号查询用户出错",e);
        }
        finally {
            DButil.close((com.mysql.jdbc.Connection) c, (com.mysql.jdbc.Statement) ps,rs);
        }

    }
    //单元测试：
    @Test
    public void testQueryByUsername(){
        User query=queryByUsername("bit");
        System.out.println(query);
        Assert.assertNotNull(query);
    }
}
