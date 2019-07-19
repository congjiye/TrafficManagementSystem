package com.atcong.service;

import com.atcong.entity.TrainRouteEntity;

import java.util.List;
import java.util.Set;

public interface TrainRouteService {
    /**
     * add train_route
     */
    void addTrainRoute(String route_name);

    /**
     * add train_route
     */
    void addTrainRoute(Integer route_id,String route_name);

    /**
     * modify train_route
     */
    void modifyTrainRoute(TrainRouteEntity trainRouteEntity);

    /**
     * remove train_route
     */
    void removeTrainRoute(Integer route_id);

    /**
     * find train_route by route_id
     */
    TrainRouteEntity findTrainRoute(Integer route_id);

    /**
     * find train_route by route_name
     */
    TrainRouteEntity findTrainRoute(String route_name);

    /**
     * find all train_route
     */
    List<TrainRouteEntity> findAllTrainRoute();

    /**
     * find all route_name by train_route
     */
    Set<String> findAllTrainRoute(String routeName);
}
