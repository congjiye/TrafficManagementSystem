package com.atcong.service;

import com.atcong.entity.BusDetailsEntity;

import java.util.List;

public interface BusDetailsService {

    /**
     * add bus_details
     */
    void addBusDetails(Integer bus_id,
                       Integer route_id,
                       String bus_run_time,
                       String bus_company,
                       Integer bus_pay,
                       String bus_status);

    /**
     * add bus_details
     */
    void addBusDetails(BusDetailsEntity bus);

    /**
     * modify bus_details
     */
    void modifyBusDetails(BusDetailsEntity bus);

    /**
     * remove bus_details
     */
    void removeBusDetails(Integer bus_id);

    /**
     * find bus_details
     */
    BusDetailsEntity findBusDetails(Integer bus_id);

    /**
     * find all bus_details
     */
    List<BusDetailsEntity> findAll();
}
