package com.atcong.service;

import com.atcong.entity.SubwayDetailsEntity;

import java.util.List;

public interface SubwayDetailsService {
    /**
     * add subway_details
     */
    void addSubwayDetails(Integer subway_id,
                          Integer route_id,
                          String begin_time,
                          String end_time);

    /**
     * modify subway_details
     */
    void modifySubwayDetails(SubwayDetailsEntity subwayDetailsEntity);

    /**
     * remove subway_details
     */
    void removeSubwayDetails(Integer subway_id);

    /**
     * find subway_details by subway_id
     */
    SubwayDetailsEntity findSubwayDetails(Integer subway_id);

    /**
     * find all subway_details
     */
    List<SubwayDetailsEntity> findAllSubwayDetails();
}
