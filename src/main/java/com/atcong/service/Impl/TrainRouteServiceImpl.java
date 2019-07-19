package com.atcong.service.Impl;

import com.atcong.dao.TrainRouteDao;
import com.atcong.entity.TrainRouteEntity;
import com.atcong.service.TrainRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class TrainRouteServiceImpl implements TrainRouteService {

    @Autowired
    private TrainRouteDao trainRouteDao;

    @Override
    public void addTrainRoute(String route_name) {
        TrainRouteEntity trainRouteEntity = new TrainRouteEntity();
        trainRouteEntity.setRouteName(route_name);
        trainRouteDao.save(trainRouteEntity);
    }

    @Override
    public void addTrainRoute(Integer route_id, String route_name) {
        TrainRouteEntity trainRouteEntity = new TrainRouteEntity();
        trainRouteEntity.setRouteId(route_id);
        trainRouteEntity.setRouteName(route_name);
        trainRouteDao.save(trainRouteEntity);
    }

    @Override
    public void modifyTrainRoute(TrainRouteEntity trainRouteEntity) {
        trainRouteDao.saveAndFlush(trainRouteEntity);
    }

    @Override
    public void removeTrainRoute(Integer route_id) {
        trainRouteDao.deleteById(route_id);
    }

    @Override
    public TrainRouteEntity findTrainRoute(Integer route_id) {
        return trainRouteDao.findByRouteId(route_id);
    }

    @Override
    public TrainRouteEntity findTrainRoute(String route_name) {
        return trainRouteDao.findByRouteName(route_name);
    }

    @Override
    public List<TrainRouteEntity> findAllTrainRoute() {
        return trainRouteDao.findAll();
    }

    @Override
    public Set<String> findAllTrainRoute(String routeName) {
        List<TrainRouteEntity>list = trainRouteDao.findAll();
        Set<String> route = new TreeSet<>();
        for(int i = 0 ; i < list.size() ; i++){
            String[]getRoute = list.get(i).getRouteName().split("-");
            if(getRoute[0].indexOf(routeName) != -1){
                route.add(getRoute[0]);
            }else if(getRoute[1].indexOf(routeName) != -1){
                route.add(getRoute[1]);
            }
        }
        return route;
    }
}
