package com.atcong.service;

import com.atcong.Util.BusFindJson;
import com.atcong.Util.BusShowInfo;
import com.atcong.entity.BusInfoEntity;

import java.util.List;

public interface BusService {

    /**
     * 添加一个公交车基本信息
     * @param route,name
     * @return
     */
    void addBus(String name,Integer route);

    /**
     * 根据公交车名删除一个公交车信息
     * @return
     */
    void removeBus(String busName);

    /**
     * 根据公交车Id删除一个公交车信息
     */
    boolean removeBusById(Integer bus_id);

    /**
     * 更新一个公交车信息
     * @return
     */
    boolean modifyBus(String busName,Integer route);

    /**
     * 根据公交车名查找一个公交车信息
     * @return
     */
    BusInfoEntity findBus(String busName);

    /**
     * 根据公交车id查找一个公交车信息
     */
    BusInfoEntity findBus(Integer busId);

    /**
     * 查找所有公交车
     */
    List<BusInfoEntity> findAllBus();

    /**
     * 根据路线id查找所有公交
     */
    List<BusInfoEntity> findAllBus(Integer route_id);

    /**
     * 查找所有公交车
     * @return
     */
    List<BusFindJson> findAll();

    /**
     * 格式化公交车信息
     */
    List<?> findAll(String bus_name);

    /**
     * 查询公交显示信息
     */
    List<BusShowInfo> findAllBusInfo();

}
