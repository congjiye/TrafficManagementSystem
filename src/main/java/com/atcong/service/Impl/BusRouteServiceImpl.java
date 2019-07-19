package com.atcong.service.Impl;

import com.atcong.dao.BusRouteDao;
import com.atcong.entity.BusRouteEntity;
import com.atcong.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    @Autowired
    private BusRouteDao busRouteDao;

    @Override
    public void addBusRoute(Integer route_id, String route_name) {
        BusRouteEntity busRouteEntity = new BusRouteEntity();
        busRouteEntity.setRouteId(route_id);
        busRouteEntity.setRouteName(route_name);
        busRouteDao.save(busRouteEntity);
    }

    @Override
    public void modifyBusRoute(BusRouteEntity busRouteEntity) {
        busRouteDao.saveAndFlush(busRouteEntity);
    }

    @Override
    public boolean removeBusRoute(Integer route_id) {
        if(busRouteDao.findByRouteId(route_id) != null) {
            busRouteDao.deleteById(route_id);
            return true;
        }
        return false;
    }

    @Override
    public BusRouteEntity findBusRoute(Integer route_id) {
        return busRouteDao.findByRouteId(route_id);
    }

    @Override
    public List<BusRouteEntity> findAllBusRoute() {
        return busRouteDao.findAll();
    }

    @Override
    public BusRouteEntity findBusRoute(String route_name) {
        return busRouteDao.findByRouteName(route_name);
    }
}
