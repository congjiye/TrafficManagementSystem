package com.atcong.dao;

import com.atcong.entity.BusRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRouteDao extends JpaRepository<BusRouteEntity,Integer> {

    @Query(value = "select * from bus_route where route_name = ?1",nativeQuery = true)
    BusRouteEntity findByRouteName(String route_name);

    @Query(value = "select * from bus_route where route_id = ?1",nativeQuery = true)
    BusRouteEntity findByRouteId(Integer route_id);
}
