package com.atcong.service;

import com.atcong.entity.PlaneDetailsEntity;

import java.util.List;

public interface PlaneDetailsService {
    /**
     * add plane_details
     */
    void addPlaneDetails(Integer plane_id,String begin_time,String end_time);

    /**
     * modify plane_details
     */
    void modifyPlaneDetails(PlaneDetailsEntity planeDetailsEntity);

    /**
     * remoce plane_details
     */
    void removePlaneDetails(Integer plane_id);

    /**
     * find by plane_id
     */
    PlaneDetailsEntity findPlaneDetails(Integer plane_id);

    /**
     * find all plane_details
     */
    List<PlaneDetailsEntity> findAllPlaneDetails();
}
