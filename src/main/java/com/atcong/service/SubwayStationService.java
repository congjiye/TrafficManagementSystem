package com.atcong.service;

import com.atcong.entity.SubwayStationEntity;

import java.util.List;

public interface SubwayStationService {

    /**
     * add subway_station
     */
    void addSubwayStation(Integer station_id,String station_name,Integer route_id);

    /**
     * modify subway_station
     */
    void modifySubwayStation(SubwayStationEntity subwayStationEntity);

    /**
     * remove subway_station
     */
    void removeSubwayStation(Integer station_id);

    /**
     * find subway_station by station_id
     */
    SubwayStationEntity findSubwayStation(Integer station_id);

    /**
     * find all subway_station
     */
    List<SubwayStationEntity> findAllSubwayStation();

    /**
     * find all subway_station where route_id = ?
     */
    List<SubwayStationEntity> findAllSubwayStation(Integer route_id);

    /**
     * find all subway_station where stationName = ?
     */
    List<SubwayStationEntity> findAllSubwayStation(String stationName);

    /**
     * find routeId by double stationName
     */
    Integer findRouteId(String stationName1,String stationName2);
}
