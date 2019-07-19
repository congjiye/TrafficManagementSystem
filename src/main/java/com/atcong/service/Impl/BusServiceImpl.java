package com.atcong.service.Impl;

import com.atcong.Util.BusFindJson;
import com.atcong.Util.BusShowInfo;
import com.atcong.dao.BusDao;
import com.atcong.entity.BusInfoEntity;
import com.atcong.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDao busDao;

    @Override
    public void addBus(String name,Integer route){
        BusInfoEntity bus = new BusInfoEntity();
        bus.setBusName(name);
        bus.setRouteId(route);
        busDao.save(bus);
    }

    @Override
    public boolean modifyBus(String busName,Integer route) {
        if(busDao.findByBusName(busName) != null){
            BusInfoEntity bus = busDao.findByBusName(busName);
            bus.setRouteId(route);
            busDao.saveAndFlush(bus);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBusById(Integer bus_id) {
        if(busDao.findById(bus_id) != null){
            busDao.deleteById(bus_id);
            return true;
        }
        return false;
    }

    @Override
    public void removeBus(String busName) {
        busDao.deleteByBusName(busName);
    }

    @Override
    public BusInfoEntity findBus(String busName) {
        return busDao.findByBusName(busName);
    }

    @Override
    public BusInfoEntity findBus(Integer busId) {
        return busDao.findById(busId).get();
    }

    @Override
    public List<BusInfoEntity> findAllBus() {
        return busDao.findAll();
    }

    @Override
    public List<BusFindJson> findAll() {
        List<BusFindJson> list = new ArrayList<>();
        List<?> busList = new ArrayList<>();
        busList = busDao.findAllBus();
        for(Object o : busList){
            Object[] array = (Object[])o;
            BusFindJson busFindJson = new BusFindJson();
            busFindJson.setBus_id((Integer)array[0]);
            busFindJson.setBus_name((String)array[1]);
            busFindJson.setRoute_name((String)array[2]);
            list.add(busFindJson);
        }
        return list;
    }

    @Override
    public List<?> findAll(String bus_name) {
        List<BusFindJson> list = new ArrayList<>();
        List<?> busList = new ArrayList<>();
        busList = busDao.findAllBus();
        for(Object o : busList){
            Object[] array = (Object[])o;
            if((Integer)array[0] == busDao.findByBusName(bus_name).getBusId()){
                BusFindJson busFindJson = new BusFindJson((Integer)array[0],(String)array[1],(String)array[2]);
                list.add(busFindJson);
            }
        }
        return list;
    }

    @Override
    public List<BusInfoEntity> findAllBus(Integer route_id) {
        List<BusInfoEntity> busInfoEntities = new ArrayList<>();
        busInfoEntities = busDao.findAllByRouteId(route_id);
        return busInfoEntities;
    }

    @Override
    public List<BusShowInfo> findAllBusInfo() {
        List<BusShowInfo> list = new ArrayList<>();
        List<?> busList = busDao.findAllByBusName();
        for(Object o : busList){
            Object[] array = (Object[])o;
            BusShowInfo busShowInfo = new BusShowInfo((String)array[0],(String)array[1],(Integer)array[2]);
            list.add(busShowInfo);
        }
        return list;
    }


}
