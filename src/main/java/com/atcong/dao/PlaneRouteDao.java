package com.atcong.dao;

import com.atcong.entity.PlaneRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaneRouteDao extends JpaRepository<PlaneRouteEntity,Integer> {
    @Query(value = "select * from plane_route where route_name = ?1",nativeQuery = true)
    PlaneRouteEntity findByRouteName(String routeName);
}
