package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-14
 * Time:20:12
 */
@Getter
@Setter
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private java.util.Date createTime;
    private Integer user_id;


}
