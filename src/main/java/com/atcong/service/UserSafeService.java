package com.atcong.service;

public interface UserSafeService {
    String findUserSafe(Integer userId);

    void modifyUserSafe(Integer userId,String mail);
}
