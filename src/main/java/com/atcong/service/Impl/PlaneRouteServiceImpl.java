package com.atcong.service.Impl;

import com.atcong.dao.PlaneRouteDao;
import com.atcong.entity.PlaneRouteEntity;
import com.atcong.service.PlaneRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneRouteServiceImpl implements PlaneRouteService {

    @Autowired
    private PlaneRouteDao planeRouteDao;

    @Override
    public void addPlaneRoute(String route_name) {
        PlaneRouteEntity planeRouteEntity = new PlaneRouteEntity();
        planeRouteEntity.setRouteName(route_name);
        planeRouteDao.save(planeRouteEntity);
    }

    @Override
    public void modifyPlaneRoute(PlaneRouteEntity planeRouteEntity) {
        planeRouteDao.saveAndFlush(planeRouteEntity);
    }

    @Override
    public void removePlaneRoute(Integer route_id) {
        planeRouteDao.deleteById(route_id);
    }

    @Override
    public PlaneRouteEntity findPlaneRoute(Integer route_id) {
        return planeRouteDao.findById(route_id).get();
    }

    @Override
    public PlaneRouteEntity findPlaneRoute(String route_name) {
        return  planeRouteDao.findByRouteName(route_name);
    }

    @Override
    public List<PlaneRouteEntity> findAllPlaneRoute() {
        return planeRouteDao.findAll();
    }
}
