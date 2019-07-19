package com.atcong.dao;

import com.atcong.entity.SubwayInfoEntity;
import com.atcong.entity.SubwayRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubwayRouteDao extends JpaRepository<SubwayRouteEntity,Integer> {
    @Query(value = "select * from subway_route where route_name = ?1",nativeQuery = true)
    SubwayRouteEntity findByRouteName(String route_name);
}
