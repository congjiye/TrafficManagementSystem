package com.atcong.service.Impl;

import com.atcong.dao.SubwayDao;
import com.atcong.dao.SubwayDetailsDao;
import com.atcong.entity.SubwayDetailsEntity;
import com.atcong.service.SubwayDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubwayDetailsServiceImpl implements SubwayDetailsService {

    @Autowired
    private SubwayDetailsDao subwayDetailsDao;

    @Override
    public void addSubwayDetails(Integer subway_id, Integer route_id, String begin_time, String end_time) {
        SubwayDetailsEntity subwayDetailsEntity = new SubwayDetailsEntity();
        subwayDetailsEntity.setSubwayId(subway_id);
        subwayDetailsEntity.setRouteId(route_id);
        subwayDetailsEntity.setSubwayBeginTime(begin_time);
        subwayDetailsEntity.setSubwayEndTime(end_time);
        subwayDetailsDao.save(subwayDetailsEntity);
    }

    @Override
    public void modifySubwayDetails(SubwayDetailsEntity subwayDetailsEntity) {
        subwayDetailsDao.saveAndFlush(subwayDetailsEntity);
    }

    @Override
    public void removeSubwayDetails(Integer subway_id) {
        subwayDetailsDao.deleteById(subway_id);
    }

    @Override
    public SubwayDetailsEntity findSubwayDetails(Integer subway_id) {
        return subwayDetailsDao.findBySubwayId(subway_id);
    }

    @Override
    public List<SubwayDetailsEntity> findAllSubwayDetails() {
        return subwayDetailsDao.findAll();
    }
}
