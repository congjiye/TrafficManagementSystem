package com.atcong.service.Impl;

import com.atcong.Util.BusFindJson;
import com.atcong.Util.SubwayFindJson;
import com.atcong.dao.SubwayDao;
import com.atcong.entity.SubwayInfoEntity;
import com.atcong.entity.SubwayRouteEntity;
import com.atcong.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubwayServiceImpl implements SubwayService {

    @Autowired
    private SubwayDao subwayDao;

    @Override
    public void addSubway(String subwayName,Integer route,Integer subwayId) {
        SubwayInfoEntity subway = new SubwayInfoEntity();
        subway.setSubwayName(subwayName);
        subway.setSubwayRoute(route);
        subway.setSubwayId(subwayId);
        subwayDao.save(subway);
    }

    @Override
    public void removeSubway(String subwayName) {
        subwayDao.deleteBySubwayName(subwayName);
    }

    @Override
    public void removeSubway(Integer subwayId) {
        subwayDao.deleteById(subwayId);
    }

    @Override
    public void modifySubway(SubwayInfoEntity subway) {
        subwayDao.saveAndFlush(subway);
    }

    @Override
    public void modifySubway(String subwayName, Integer route) {
        SubwayInfoEntity subwayInfoEntity = subwayDao.findBySubwayName(subwayName);
        subwayInfoEntity.setSubwayRoute(route);
        subwayDao.saveAndFlush(subwayInfoEntity);
    }

    @Override
    public SubwayInfoEntity findSubway(String subwayName) {
        return subwayDao.findBySubwayName(subwayName);
    }

    @Override
    public SubwayInfoEntity findSubway(Integer subwayId) {
        return subwayDao.findBySubwayId(subwayId);
    }

    @Override
    public List<SubwayInfoEntity> findall() {
        List<SubwayInfoEntity> subwayList = new ArrayList<>();
        subwayList = subwayDao.findAll();
        return subwayList;
    }

    @Override
    public List<?> findAll() {
        List<SubwayFindJson>subway = new ArrayList<>();
        List<?>subwayList = new ArrayList<>();
        subwayList = subwayDao.findAllSubway();
        for(Object o : subwayList){
            Object[]arry = (Object[])o;
            SubwayFindJson subwayFindJson = new SubwayFindJson();
            subwayFindJson.setSubwayName((String)arry[0]);
            subwayFindJson.setSubwayId((Integer)arry[1]);
            subwayFindJson.setRouteName((String)arry[2]);
            subway.add(subwayFindJson);
        }
        return subway;
    }

    @Override
    public List<?> findAll(String subwayName) {
        List<SubwayFindJson>subway = new ArrayList<>();
        List<?>subwayList = subwayDao.findAllSubway();
        for(Object o : subwayList){
            Object[]arry = (Object[])o;
            if(((String)arry[0]).equals(subwayName)){
                SubwayFindJson subwayFindJson = new SubwayFindJson((String)arry[0],(String)arry[2],(Integer)arry[1]);
                subway.add(subwayFindJson);
            }
        }
        return subway;
    }

    @Override
    public List<SubwayInfoEntity> findAll(Integer routeId) {
        return subwayDao.findAllBySubwayRoute(routeId);
    }
}
