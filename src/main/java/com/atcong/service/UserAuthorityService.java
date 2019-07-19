package com.atcong.service;

import com.atcong.Util.UserAuthorityFind;
import com.atcong.entity.UserAuthorityEntity;

import java.util.List;

public interface UserAuthorityService {
    /**
     * find all user_authority
     */
    List<UserAuthorityFind> findAll();

    void addUserAuthority(Integer userId,Integer authority);

    /**
     * find by user_id
     */
    UserAuthorityEntity findUserAuthority(Integer userId);

    /**
     * delete by user_id
     */
    void removeByUserId(Integer userId);

    /**
     * modify by user_id
     */
    void modifyUserAuthority(Integer userId,Integer authority);
}
