package com.lagou.domain;

import org.junit.Test;

import javax.servlet.http.Cookie;
import java.util.ArrayList;

public class User {


    private int id;
    private String username;


  /*  @Test
    public void sss(Cookie cookie){

        for (Object o : cookie) {
            
        }
    }*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
