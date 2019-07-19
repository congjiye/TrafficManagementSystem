package com.atcong.service.Impl;

import com.atcong.Util.TrainFindJson;
import com.atcong.dao.TrainDao;
import com.atcong.entity.TrainInfoEntity;
import com.atcong.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    @Override
    public void addTrain(String trainName,Integer route) {
        TrainInfoEntity train = new TrainInfoEntity();
        train.setTrainName(trainName);
        train.setTrainRoute(route);
        trainDao.save(train);
    }

    @Override
    public void removeTrain(String trainName) {
        trainDao.deleteByTrainName(trainName);
    }

    @Override
    public void removeTrain(Integer trainId) {
        trainDao.deleteById(trainId);
    }

    @Override
    public void modifyTrain(TrainInfoEntity train) {
        trainDao.saveAndFlush(train);
    }

    @Override
    public TrainInfoEntity findTrain(String trainName) {
        return trainDao.findByTrainName(trainName);
    }

    @Override
    public TrainInfoEntity findTrain(Integer trainId) {
        return trainDao.findByTrainId(trainId);
    }

    @Override
    public List<TrainInfoEntity> findAll() {
        List<TrainInfoEntity> trainList = new ArrayList<>();
        trainList = trainDao.findAll();
        return trainList;
    }

    @Override
    public List<?> findAllTrainInfo(String trainName) {
        List<?>list = trainDao.findAllTrainInfo();
        List<TrainFindJson>find = new ArrayList<>();
        for(Object o : list){
            Object[]arry = (Object[])o;
            if(((String)arry[1]).equals(trainName)){
                TrainFindJson trainFindJson = new TrainFindJson((Integer)arry[0],(String)arry[1],(String)arry[2]);
                find.add(trainFindJson);
            }
        }
        return find;
    }

    @Override
    public List<TrainFindJson> findAllTrainInfo() {
        List<?>list = trainDao.findAllTrainInfo();
        List<TrainFindJson>find = new ArrayList<>();
        for(Object o : list){
            Object[]arry = (Object[])o;
            TrainFindJson trainFindJson = new TrainFindJson((Integer)arry[0],(String)arry[1],(String)arry[2]);
            find.add(trainFindJson);
        }
        return find;
    }

    @Override
    public List<TrainInfoEntity> findAllTrain(Integer routeId) {
        return trainDao.findAllByTrainRoute(routeId);
    }

    @Override
    public List<TrainFindJson> findAllTrain(String routeName) {
        String[] strings = routeName.split("-");
        List<TrainFindJson>list = this.findAllTrainInfo();
        List<TrainFindJson>trainList = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){
            String[] routeString = list.get(i).getRouteName().split("-");
            if(routeString[0].indexOf(strings[0].substring(0,2)) != -1 && routeString[1].indexOf(strings[1].substring(0,2)) != -1){
                trainList.add(list.get(i));
            }
        }
        return trainList;
    }

    @Override
    public List<TrainFindJson> findAllTrainByTime(String beginTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String data = dateFormat.format(new Date()).toString();
        System.out.println(data);
        return null;
    }
}
