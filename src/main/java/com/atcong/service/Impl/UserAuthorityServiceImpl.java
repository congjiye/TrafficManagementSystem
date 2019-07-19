package com.atcong.service.Impl;

import com.atcong.Util.UserAuthorityFind;
import com.atcong.dao.UserAuthorityDao;
import com.atcong.entity.UserAuthorityEntity;
import com.atcong.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {
    @Autowired
    private UserAuthorityDao userAuthorityDao;

    @Override
    public List<UserAuthorityFind> findAll() {
        List<?>list = userAuthorityDao.findAllBy_AndUserId();
        List<UserAuthorityFind>userAuthority = new ArrayList<>();
        for(Object o : list){
            Object[]arry = (Object[])o;
            UserAuthorityFind userAuthorityFind = new UserAuthorityFind((String)arry[1],(Integer)arry[0],(Integer) arry[2]);
            userAuthority.add(userAuthorityFind);
        }
        return userAuthority;
    }

    @Override
    public void addUserAuthority(Integer userId,Integer authority) {
        UserAuthorityEntity userAuthorityEntity = new UserAuthorityEntity();
        userAuthorityEntity.setUserId(userId);
        userAuthorityEntity.setUserAuthority(authority);
        userAuthorityDao.save(userAuthorityEntity);
    }

    @Override
    public UserAuthorityEntity findUserAuthority(Integer userId) {
        return userAuthorityDao.findByUserId(userId);
    }

    @Override
    public void removeByUserId(Integer userId) {
        userAuthorityDao.deleteById(userId);
    }

    @Override
    public void modifyUserAuthority(Integer userId,Integer authority) {
        UserAuthorityEntity userAuthorityEntity = userAuthorityDao.findByUserId(userId);
        userAuthorityEntity.setUserAuthority(authority);
        userAuthorityDao.saveAndFlush(userAuthorityEntity);
    }
}
