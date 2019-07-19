package com.atcong.service.Impl;

import com.atcong.dao.UserSafeDao;
import com.atcong.entity.UserSafeEntity;
import com.atcong.service.UserSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSafeServiceImpl implements UserSafeService {
    @Autowired
    private UserSafeDao userSafeDao;

    @Override
    public String findUserSafe(Integer userId) {
        return userSafeDao.findByUserId(userId).getUserEmail();
    }

    @Override
    public void modifyUserSafe(Integer userId,String mail) {
        UserSafeEntity userSafeEntity = userSafeDao.findByUserId(userId);
        userSafeEntity.setUserEmail(mail);
        userSafeDao.saveAndFlush(userSafeEntity);
    }
}
