package com.atcong.service;

import com.atcong.entity.TrainDetailsEntity;

import java.util.List;

public interface TrainDetailsService {
    /**
     * add train_details
     */
    void addTrainDetails(Integer train_id,
                         String begin_time,
                         String end_time);

    /**
     * modify train_detils
     */
    void modifyTrainDetails(TrainDetailsEntity trainDetailsEntity);

    /**
     * remove train_details
     */
    void removeTrainDetails(Integer train_id);

    /**
     * find train_details by train_id
     */
    TrainDetailsEntity findTrainDetail(Integer train_id);


    /**
     * find all train_details
     */
    List<TrainDetailsEntity> findAllTrainDetails();
}
