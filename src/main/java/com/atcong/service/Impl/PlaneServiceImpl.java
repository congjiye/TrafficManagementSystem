package com.atcong.service.Impl;

import com.atcong.Util.PlaneFindDetils;
import com.atcong.Util.PlaneFindJson;
import com.atcong.dao.PlaneDao;
import com.atcong.entity.PlaneInfoEntity;
import com.atcong.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    private PlaneDao planeDao;

    @Override
    public void modifyPlane(PlaneInfoEntity plane) {
        planeDao.saveAndFlush(plane);
    }

    @Override
    public void addPlane(Integer planeId,String planeName,Integer route) {
        PlaneInfoEntity plane = new PlaneInfoEntity();
        plane.setPlaneId(planeId);
        plane.setPlaneName(planeName);
        plane.setPlaneRoute(route);
        planeDao.save(plane);
    }

    @Override
    public void removePlane(String planeName) {
        planeDao.deleteByPlaneName(planeName);
    }

    @Override
    public PlaneInfoEntity findPlane(String planeName) {
        return planeDao.findByPlaneName(planeName);
    }

    @Override
    public List<PlaneInfoEntity> findall() {
       List<PlaneInfoEntity> planeList = new ArrayList<>();
       planeList = planeDao.findAll();
       return planeList;
    }

    @Override
    public List<?> findAll() {
        List<?>list = planeDao.findAllPlane();
        List<PlaneFindJson>planeFindJsons = new ArrayList<>();
        for(Object o : list){
            Object[]arry = (Object[])o;
            planeFindJsons.add(new PlaneFindJson((Integer)arry[0],(String)arry[1],(String)arry[2]));
        }
        return planeFindJsons;
    }

    @Override
    public List<?> findAll(String planeName) {
        List<?>list = planeDao.findAllPlane();
        List<PlaneFindJson>planeFindJsons = new ArrayList<>();
        for(Object o : list){
            Object[]arry = (Object[])o;
            if(((String)arry[1]).equals(planeName)){
                planeFindJsons.add(new PlaneFindJson((Integer)arry[0],(String)arry[1],(String)arry[2]));
            }
        }
        return planeFindJsons;
    }

    @Override
    public List<PlaneInfoEntity> findAll(Integer route) {
        return planeDao.findAllByPlaneRoute(route);
    }

    @Override
    public List<PlaneFindDetils> findAllPlaneDetails(String routeName) {
        List<?> list = planeDao.findAllPlaneDetails();
        List<PlaneFindDetils> plane = new ArrayList<>();
        for(Object o : list){
            Object[]arry = (Object[])o;
            if(((String)arry[1]).equals(routeName)){
                plane.add(new PlaneFindDetils((String)arry[0],(String)arry[1],(String)arry[2],(String)arry[3]));
            }
        }
        return plane;
    }

    @Override
    public List<PlaneFindDetils> findAllPlane(String datetime, String routeName) {
        String[]date = datetime.split(":");
        List<PlaneFindDetils>list = this.findAllPlaneDetails(routeName);
        List<PlaneFindDetils>detils = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){
            String[] listDate = list.get(i).getPlaneBeginTime().split(":");
            if(Integer.parseInt(listDate[0]) > Integer.parseInt(date[0])){
                detils.add(list.get(i));
                continue;
            }
            if(Integer.parseInt(listDate[0]) == Integer.parseInt(date[0]) && Integer.parseInt(listDate[1]) >= Integer.parseInt(date[1])){
                detils.add(list.get(i));
            }
        }
        return detils;
    }
}
