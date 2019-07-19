package com.atcong.service.Impl;

import com.atcong.dao.SubwayRouteDao;
import com.atcong.entity.SubwayRouteEntity;
import com.atcong.service.SubwayRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubwayRouteServiceImpl implements SubwayRouteService {

    @Autowired
    private SubwayRouteDao subwayRouteDao;

    @Override
    public void addSubwayRoute(String route_name) {
        SubwayRouteEntity subwayRouteEntity = new SubwayRouteEntity();
        subwayRouteEntity.setRouteName(route_name);
        subwayRouteDao.save(subwayRouteEntity);
    }

    @Override
    public void modifySubwayRoute(SubwayRouteEntity subwayRouteEntity) {
        subwayRouteDao.saveAndFlush(subwayRouteEntity);
    }

    @Override
    public void removeSubwayRoute(Integer route_id) {
        subwayRouteDao.deleteById(route_id);
    }

    @Override
    public SubwayRouteEntity findSubwayRoute(Integer route_id) {
        return subwayRouteDao.findById(route_id).get();
    }

    @Override
    public SubwayRouteEntity findSubwayRoute(String route_name) {
        return subwayRouteDao.findByRouteName(route_name);
    }

    @Override
    public List<SubwayRouteEntity> findAllSubwayRoute() {
        return subwayRouteDao.findAll();
    }
}
