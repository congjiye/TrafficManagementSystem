package com.atcong.dao;

import com.atcong.entity.TrainRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainRouteDao extends JpaRepository<TrainRouteEntity,Integer> {
    @Query(value = "select * from train_route where route_id = ?1",nativeQuery = true)
    TrainRouteEntity findByRouteId(Integer routeId);

    @Query(value = "select * from train_route where route_name = ?1",nativeQuery = true)
    TrainRouteEntity findByRouteName(String routeName);
}
