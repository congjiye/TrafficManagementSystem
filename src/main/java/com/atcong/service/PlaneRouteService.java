package com.atcong.service;

import com.atcong.entity.PlaneRouteEntity;

import java.util.List;

public interface PlaneRouteService {

    /**
     * add plane_route
     */
    void addPlaneRoute(String route_name);

    /**
     * modify plane_route
     */
    void modifyPlaneRoute(PlaneRouteEntity planeRouteEntity);

    /**
     * remove plane_route
     */
    void removePlaneRoute(Integer route_id);

    /**
     * find plane_route by route_id
     */
    PlaneRouteEntity findPlaneRoute(Integer route_id);

    /**
     * find plane_route by route_name
     */
    PlaneRouteEntity findPlaneRoute(String route_name);

    /**
     * find all plane_route
     */
    List<PlaneRouteEntity> findAllPlaneRoute();
}
