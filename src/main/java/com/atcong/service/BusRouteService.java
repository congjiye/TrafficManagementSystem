package com.atcong.service;

import com.atcong.entity.BusRouteEntity;

import java.util.List;

public interface BusRouteService {

    /**
     * add bus_route
     */
    void addBusRoute(Integer route_id,String route_name);

    /**
     * modify bus_route
     */
    void modifyBusRoute(BusRouteEntity busRouteEntity);

    /**
     * remove bus_route
     */
    boolean removeBusRoute(Integer route_id);

    /**
     * find bus_route by route_id
     */
    BusRouteEntity findBusRoute(Integer route_id);

    /**
     * find bus_route by route_name
     */
    BusRouteEntity findBusRoute(String route_name);

    /**
     * find all bus_route
     */
    List<BusRouteEntity> findAllBusRoute();
}
