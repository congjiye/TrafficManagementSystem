package com.atcong.service.Impl;

import com.atcong.dao.BusStationDao;
import com.atcong.entity.BusStationEntity;
import com.atcong.service.BusStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusStationServiceImpl implements BusStationService {

    @Autowired
    private BusStationDao busStationDao;

    @Override
    public void addBusStation(Integer route_id, String station_name,Integer station_id,String station_position) {
        BusStationEntity bus_station = new BusStationEntity();
        bus_station.setRouteId(route_id);
        bus_station.setStationId(station_id);
        bus_station.setBusPostison(station_position);
        bus_station.setStationName(station_name);
        busStationDao.save(bus_station);
    }

    @Override
    public void modifyBusStation(BusStationEntity bus_station) {
        busStationDao.saveAndFlush(bus_station);
    }

    @Override
    public void removeBusStation(Integer station_id) {
        busStationDao.deleteById(station_id);
    }

    @Override
    public BusStationEntity findBusStation(Integer station_id) {
        return busStationDao.findById(station_id).get();
    }

    @Override
    public BusStationEntity findBusStation(String bus_position, Integer route_id) {
        return busStationDao.findByRouteIdAndBusPostison(bus_position,route_id);
    }

    @Override
    public List<BusStationEntity> findAllBusStation() {
        List<BusStationEntity> bus_station_list = new ArrayList<>();
        bus_station_list = busStationDao.findAll();
        return bus_station_list;
    }

    @Override
    public List<BusStationEntity> findAllBusStation(Integer route_id) {
        List<BusStationEntity> bus_station_list = new ArrayList<>();
        bus_station_list = busStationDao.findAllByRouteId(route_id);
        return bus_station_list;
    }

    @Override
    public List<BusStationEntity> findAllBusStation(String station_name) {
        List<BusStationEntity> bus_station_list = new ArrayList<>();
        bus_station_list = busStationDao.findAllByStationName(station_name);
        return bus_station_list;
    }

    @Override
    public Integer findRouteId(String station1, String station2) {
        List<BusStationEntity>list1 = busStationDao.findAllByStationName(station1);
        List<BusStationEntity>list2 = busStationDao.findAllByStationName(station2);
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
