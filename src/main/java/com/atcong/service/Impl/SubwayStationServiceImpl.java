package com.atcong.service.Impl;

import com.atcong.dao.SubwayStationDao;
import com.atcong.entity.SubwayStationEntity;
import com.atcong.service.SubwayStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubwayStationServiceImpl implements SubwayStationService {

    @Autowired
    private SubwayStationDao subwayStationDao;

    @Override
    public void addSubwayStation(Integer station_id, String station_name,Integer route_id) {
        SubwayStationEntity subwayStationEntity = new SubwayStationEntity();
        subwayStationEntity.setStationId(station_id);
        subwayStationEntity.setRouteId(route_id);
        subwayStationEntity.setStationName(station_name);
        subwayStationDao.save(subwayStationEntity);
    }

    @Override
    public void modifySubwayStation(SubwayStationEntity subwayStationEntity) {
        subwayStationDao.saveAndFlush(subwayStationEntity);
    }

    @Override
    public void removeSubwayStation(Integer station_id) {
        subwayStationDao.deleteById(station_id);
    }

    @Override
    public SubwayStationEntity findSubwayStation(Integer station_id) {
        return subwayStationDao.findByStationId(station_id);
    }

    @Override
    public List<SubwayStationEntity> findAllSubwayStation() {
        return subwayStationDao.findAll();
    }

    @Override
    public List<SubwayStationEntity> findAllSubwayStation(Integer route_id) {
        return subwayStationDao.findAllByRouteId(route_id);
    }

    @Override
    public List<SubwayStationEntity> findAllSubwayStation(String stationName) {
        return subwayStationDao.findAllByStationName(stationName);
    }

    @Override
    public Integer findRouteId(String stationName1, String stationName2) {
        List<SubwayStationEntity>list1 = subwayStationDao.findAllByStationName(stationName1);
        List<SubwayStationEntity>list2 = subwayStationDao.findAllByStationName(stationName2);
        Integer route = 0;
        for(int i = 0 ; i < list1.size() ; i++){
            for(int j = 0 ; j < list2.size() ; j++){
                if(list1.get(i).getRouteId() == list2.get(j).getRouteId()){
                    route = list1.get(i).getRouteId();
                }
            }
        }
        return route;
    }
}
