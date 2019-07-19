package com.atcong.Util;

public class UserAuthorityFind {
    private String username;
    private Integer userId;
    private String authority;

    public UserAuthorityFind(){}

    public UserAuthorityFind(String username,Integer userId,Integer authority){
        this.username = username;
        this.userId = userId;
        if(authority == 0){
            this.authority = "普通用户";
        }else {
            this.authority = "管理员";
        }
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
