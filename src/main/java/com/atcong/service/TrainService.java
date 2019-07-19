package com.atcong.service;

import com.atcong.Util.TrainFindJson;
import com.atcong.entity.TrainInfoEntity;

import java.util.List;

public interface TrainService {
    /**
     * 添加火车
     * @param name,route
     */
    void addTrain(String name,Integer route);

    /**
     * 修改火车
     * @param train
     */
    void modifyTrain(TrainInfoEntity train);

    /**
     * 根据火车名
     * 删除火车
     */
    void removeTrain(String trainName);

    /**
     * delete by train_id
     */
    void removeTrain(Integer trainId);

    /**
     * 查找所有train
     * @return
     */
    List<TrainInfoEntity> findAll();

    /**
     * 根据trainName查找一个train
     */
    TrainInfoEntity findTrain(String trainName);

    /**
     * 根据trainID查找一个train
     */
    TrainInfoEntity findTrain(Integer trainId);

    /**
     * find all train by routeId
     */
    List<TrainInfoEntity> findAllTrain(Integer routeId);

    /**
     * 根据trainName查询所有符合的列车信息
     */
    List<?> findAllTrainInfo(String trainName);

    /**
     * 查询所有列车信息，路线显示路线名
     */
    List<TrainFindJson> findAllTrainInfo();

    /**
     * 根据出发地目的地站点模糊查询显示所有符合条件的列车信息
     */
    List<TrainFindJson> findAllTrain(String routeName);

    /**
     * 根据本地时间显示可以选择的出行列车
     */
    List<TrainFindJson> findAllTrainByTime(String beginTime);
}
