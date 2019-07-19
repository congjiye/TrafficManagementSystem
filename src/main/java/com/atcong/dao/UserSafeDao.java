package com.atcong.dao;

import com.atcong.entity.UserSafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserSafeDao extends JpaRepository<UserSafeEntity,Integer> {
    @Query(value = "select * from  user_safe where user_id = ?1",nativeQuery = true)
    UserSafeEntity findByUserId(Integer userId);
}
