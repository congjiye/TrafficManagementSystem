package com.atcong.service;

import com.atcong.entity.UserInfoEntity;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param username,password
     */
    public boolean addUser(String username,String password);

    /**
     * 修改用户
     */
    public void modifyUser(Integer id,String username,String password);

    /**
     * 根据用户Id
     * 删除用户
     */
    public void removeUser(Integer id);

    /**
     * 查找所有user
     * @return
     */
    List<UserInfoEntity> findAll();

    /**
     * 根据用户名查找一个User
     */
    UserInfoEntity findUser(String userName);

    /**
     * 验证用户登录是否成功
     */
    boolean userLogin(String userName,String passWord);
}
