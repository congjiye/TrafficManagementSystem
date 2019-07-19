package com.atcong.dao;

import com.atcong.entity.UserAuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAuthorityDao extends JpaRepository<UserAuthorityEntity,Integer> {
    @Query(value = "select ui.user_id,ui.user_name,ua.user_authority from user_authority ua,user_info ui where ua.user_id = ui.user_id",nativeQuery = true)
    List<?> findAllBy_AndUserId();

    @Query(value = "select * from user_authority where user_id = ?1",nativeQuery = true)
    UserAuthorityEntity findByUserId(Integer userId);

}
