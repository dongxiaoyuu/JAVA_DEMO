package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Article;
import org.example.model.User;
import org.junit.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Description:封装Session校验，访问敏感资源需要验证是否登录
 * User:dxy
 * Date:2022-06-14
 * Time:20:56
 */
public class WebUtil {
    private static final ObjectMapper MAPPER=new ObjectMapper();
    static {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        MAPPER.setDateFormat(df);
    }
    public static User validateLogin(HttpServletRequest req){
        HttpSession session=req.getSession(false);
        User user=null;
        if(session!=null){
             user=(User) session.getAttribute("user");
        }
        return user;
    }
    public static void serialize(HttpServletResponse resp, Object o){
        try {
            resp.setContentType("utf-8");
            resp.setContentType("application/json");
            String body=MAPPER.writeValueAsString(o);
            resp.getWriter().write(body);
        } catch (IOException e) {
            throw new RuntimeException("序列化出错",e);
        }
    }
    public static <T> T deserialize(HttpServletRequest req,Class<T> clazz){
        try {
            return MAPPER.readValue(req.getInputStream(),clazz);
        } catch (IOException e) {
            throw new RuntimeException("反序列化异常",e);
        }

    }
    //junit测试
    @Test
    public void test() throws JsonProcessingException {
        Article a =new Article();
        a.setId(001);
        a.setTitle("hello world");
        a.setContent("content");
        a.setCreateTime(new Date());
        a.setUser_id(2);
        String json=MAPPER.writeValueAsString(a);
        System.out.println(json);
    }
}
