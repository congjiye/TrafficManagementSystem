package com.atcong.dao;

import com.atcong.entity.PlaneDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaneDetailsDao extends JpaRepository<PlaneDetailsEntity,Integer> {
    @Query(value = "select * from plane_details where plane_id = ?1",nativeQuery = true)
    PlaneDetailsEntity findByPlaneId(Integer plane_id);
}
