package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-06-14
 * Time:20:10
 */
@Getter
@Setter
@ToString

public class User {
    private  Integer id;
    private String  username;
    private String password;
    private String nickname;
    private String head;
    private String github;
}
