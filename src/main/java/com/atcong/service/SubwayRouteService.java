package com.atcong.service;

import com.atcong.entity.SubwayRouteEntity;

import java.util.List;

public interface SubwayRouteService {

    /**
     * add subway_route
     */
    void addSubwayRoute(String route_name);

    /**
     * modify subway_route
     */
    void modifySubwayRoute(SubwayRouteEntity subwayRouteEntity);

    /**
     * remove subway_route
     */
    void removeSubwayRoute(Integer route_id);

    /**
     * find subway_route by route_id
     */
    SubwayRouteEntity findSubwayRoute(Integer route_id);

    /**
     * find subway_route by route_name
     */
    SubwayRouteEntity findSubwayRoute(String route_name);

    /**
     * find all subway_route
     */
    List<SubwayRouteEntity> findAllSubwayRoute();
}
