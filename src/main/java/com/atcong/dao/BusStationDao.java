package com.atcong.dao;

import com.atcong.entity.BusStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusStationDao extends JpaRepository<BusStationEntity,Integer> {
    @Query(value = "select * from bus_station where route_id = ?1",nativeQuery = true)
    List<BusStationEntity> findAllByRouteId(Integer route_id);

    @Query(value = "select * from bus_station where bus_postison = ?1 and route_id = ?2",nativeQuery = true)
    BusStationEntity findByRouteIdAndBusPostison(String bus_position,Integer route_id);

    @Query(value = "select * from bus_station where station_name = ?1",nativeQuery = true)
    List<BusStationEntity> findAllByStationName(String station_name);
}
