package com.atcong.service;

import com.atcong.entity.BusStationEntity;

import java.util.List;

public interface BusStationService {
    /**
     * add bus_station
     */
    void addBusStation(Integer route_id,String station_name,Integer station_id,String station_position);

    /**
     * modify bus_station
     */
    void modifyBusStation(BusStationEntity bus_station);

    /**
     * remove bus_station
     */
    void removeBusStation(Integer station_id);

    /**
     * find bus_station by station_id
     */
    BusStationEntity findBusStation(Integer station_id);

    /**
     * find bus_station by route_id and bus_position
     */
    BusStationEntity findBusStation(String bus_position,Integer route_id);

    /**
     * find all bus_station
     */
    List<BusStationEntity> findAllBusStation();

    /**
     * find all bus_station by route_id
     */
    List<BusStationEntity> findAllBusStation(Integer route_id);

    /**
     * find all bus_station by station_name
     */
    List<BusStationEntity> findAllBusStation(String station_name);

    Integer findRouteId(String station1,String station2);
}
