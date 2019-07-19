package com.atcong.service.Impl;

import com.atcong.Util.passwordDigest;
import com.atcong.dao.UserDao;
import com.atcong.entity.UserInfoEntity;
import com.atcong.service.UserService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void removeUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public List<UserInfoEntity> findAll() {
        List<UserInfoEntity> userList = new ArrayList<>();
        userList = userDao.findAll();
        return userList;
    }

    @Override
    public UserInfoEntity findUser(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public boolean addUser(String username,String password) {
        if (userDao.findByUserName(username) != null) {
            return false;
        } else {
            try {
                password = passwordDigest.passwordTransfer(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            UserInfoEntity user = new UserInfoEntity();
            user.setUserName(username);
            user.setUserPassword(password);
            userDao.save(user);
            return true;
        }
    }

    @Override
    public void modifyUser(Integer id,String username,String password) {
        UserInfoEntity user = userDao.findById(id).get();
        try {
            user.setUserPassword(passwordDigest.passwordTransfer(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        userDao.saveAndFlush(user);
    }

    @Override
    public boolean userLogin(String userName, String passWord) {
        UserInfoEntity user = userDao.findByUserName(userName);
        if(user != null){
            try {
                if(passwordDigest.comparePassword(passWord,user.getUserPassword())){
                    return true;
                }
                else{
                    return false;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
