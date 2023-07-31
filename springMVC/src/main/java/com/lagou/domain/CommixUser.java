package com.lagou.domain;

import java.util.List;
import java.util.Map;

public class CommixUser {
    private  String keyword;
    private User user;
    private List<User> users;
    private Map<String,User> userMap;

    @Override
    public String toString() {
        return "CommixUser{" +
                "keyword='" + keyword + '\'' +
                ", user=" + user +
                ", users=" + users +
                ", userMap=" + userMap +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
