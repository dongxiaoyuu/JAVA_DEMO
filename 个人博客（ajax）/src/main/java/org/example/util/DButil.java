package org.example.util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-14
 * Time:20:32
 */
public class DButil {


    /*
    * 1.封装获取数据库连接；
    * 单例模式
    * */
    private static volatile javax.sql.DataSource DS;
    private static DataSource getDataSource(){
        if(DS==null){
            synchronized (DButil.class){
                if(DS==null){
                    MysqlDataSource ds=new MysqlDataSource();
                    ds.setURL("jdbc:mysql://localhost:3306/blog_java44");
                    ds.setUser("root");
                    ds.setPassword("666666");
                    ds.setUseSSL(false);
                    ds.setCharacterEncoding("utf8");
                    DS=ds;
                }
            }
        }
        return DS;
    }
    //提供一个开放出来给jdbc操作的代码使用工具：获取连接对象
    public static java.sql.Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败");
        }
    }
    //释放资源
    public static void close(Connection c, Statement s, ResultSet re){
        try {
            if(re!=null) re.close();
            if(c!=null) c.close();
            if(s!=null) s.close();
        } catch (SQLException e) {
            throw new RuntimeException("jdbc释放资源出错",e);
        }
    }
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }
    //@test是单元测试注解，可以直接运行（必须 public void）
    @Test
    public void test(){
        Assert.assertNotNull(getConnection());
//        System.out.println(getConnection());
    }
}
