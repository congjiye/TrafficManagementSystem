package com.atcong.service.Impl;

import com.atcong.dao.PlaneDetailsDao;
import com.atcong.entity.PlaneDetailsEntity;
import com.atcong.service.PlaneDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneDetailsServiceImpl implements PlaneDetailsService {

    @Autowired
    private PlaneDetailsDao planeDetailsDao;

    @Override
    public void addPlaneDetails(Integer plane_id, String begin_time, String end_time) {
        PlaneDetailsEntity planeDetailsEntity = new PlaneDetailsEntity();
        planeDetailsEntity.setPlaneId(plane_id);
        planeDetailsEntity.setPlaneBeginTime(begin_time);
        planeDetailsEntity.setPlaneEndTime(end_time);
        planeDetailsDao.save(planeDetailsEntity);
    }

    @Override
    public void modifyPlaneDetails(PlaneDetailsEntity planeDetailsEntity) {
        planeDetailsDao.saveAndFlush(planeDetailsEntity);
    }

    @Override
    public void removePlaneDetails(Integer plane_id) {
        planeDetailsDao.deleteById(plane_id);
    }

    @Override
    public PlaneDetailsEntity findPlaneDetails(Integer plane_id) {
        return planeDetailsDao.findByPlaneId(plane_id);
    }

    @Override
    public List<PlaneDetailsEntity> findAllPlaneDetails() {
        return planeDetailsDao.findAll();
    }
}
