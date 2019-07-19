package com.atcong.dao;

import com.atcong.entity.SubwayStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubwayStationDao extends JpaRepository<SubwayStationEntity,Integer> {
    @Query(nativeQuery = true,value = "select * from subway_station where route_id = ?1")
    List<SubwayStationEntity> findAllByRouteId(Integer route_id);

    @Query(nativeQuery = true,value = "select * from subway_station where station_name = ?1")
    List<SubwayStationEntity> findAllByStationName(String stationName);

    @Query(nativeQuery = true,value = "select * from subway_station where station_id = ?1")
    SubwayStationEntity findByStationId(Integer station_id);
}
