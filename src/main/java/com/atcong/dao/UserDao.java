package com.atcong.dao;

import com.atcong.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * user_info
 */
public interface UserDao extends JpaRepository<UserInfoEntity,Integer> {

    @Query(value = "select * from  user_info where user_name = ?1",nativeQuery = true)
    UserInfoEntity findByUserName(String user_name);
}
