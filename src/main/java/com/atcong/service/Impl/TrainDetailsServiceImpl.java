package com.atcong.service.Impl;

import com.atcong.dao.TrainDetailsDao;
import com.atcong.entity.TrainDetailsEntity;
import com.atcong.service.TrainDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainDetailsServiceImpl implements TrainDetailsService {

    @Autowired
    private TrainDetailsDao trainDetailsDao;

    @Override
    public void addTrainDetails(Integer train_id, String begin_time, String end_time) {
        TrainDetailsEntity trainDetailsEntity = new TrainDetailsEntity();
        trainDetailsEntity.setTrainId(train_id);
        trainDetailsEntity.setTrainBeginTime(begin_time);
        trainDetailsEntity.setTrainEndTime(end_time);
        trainDetailsDao.save(trainDetailsEntity);
    }

    @Override
    public void modifyTrainDetails(TrainDetailsEntity trainDetailsEntity) {
        trainDetailsDao.saveAndFlush(trainDetailsEntity);
    }

    @Override
    public void removeTrainDetails(Integer train_id) {
        trainDetailsDao.deleteById(train_id);
    }

    @Override
    public TrainDetailsEntity findTrainDetail(Integer train_id) {
        return trainDetailsDao.findByTrainId(train_id);
    }

    @Override
    public List<TrainDetailsEntity> findAllTrainDetails() {
        return trainDetailsDao.findAll();
    }
}
