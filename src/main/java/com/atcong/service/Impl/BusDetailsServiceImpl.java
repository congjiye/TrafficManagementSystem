package com.atcong.service.Impl;

import com.atcong.dao.BusDetailsDao;
import com.atcong.entity.BusDetailsEntity;
import com.atcong.service.BusDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusDetailsServiceImpl implements BusDetailsService {

    @Autowired
    private BusDetailsDao busDetailsDao;



    @Override
    public BusDetailsEntity findBusDetails(Integer bus_id) {
        if(busDetailsDao.findById(bus_id).isPresent()){
            return busDetailsDao.findById(bus_id).get();
        }
        return null;
    }

    @Override
    public List<BusDetailsEntity> findAll() {
        List<BusDetailsEntity> busList = new ArrayList<>();
        busList = busDetailsDao.findAll();
        return busList;
    }

    @Override
    public void removeBusDetails(Integer bus_id) {
        busDetailsDao.deleteById(bus_id);
    }

    @Override
    public void addBusDetails(Integer bus_id, Integer route_id, String bus_run_time, String bus_company, Integer bus_pay, String bus_status) {
        BusDetailsEntity bus = new BusDetailsEntity();
        bus.setRouteId(route_id);
        bus.setBusStatus(bus_status);
        bus.setBusId(bus_id);
        bus.setBusCompany(bus_company);
        bus.setBusPay(bus_pay);
        bus.setBusRunDate(bus_run_time);
        busDetailsDao.save(bus);
    }

    @Override
    public void addBusDetails(BusDetailsEntity bus) {
        busDetailsDao.save(bus);
    }

    @Override
    public void modifyBusDetails(BusDetailsEntity bus) {
        busDetailsDao.saveAndFlush(bus);
    }
}
