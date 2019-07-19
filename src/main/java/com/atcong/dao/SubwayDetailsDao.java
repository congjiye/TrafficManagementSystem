package com.atcong.dao;

import com.atcong.entity.SubwayDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubwayDetailsDao extends JpaRepository<SubwayDetailsEntity,Integer> {
    @Query(value = "select * from subway_details where subway_id = ?1",nativeQuery = true)
    SubwayDetailsEntity findBySubwayId(Integer subway_id);
}
