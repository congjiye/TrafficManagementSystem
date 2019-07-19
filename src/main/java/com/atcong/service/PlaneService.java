package com.atcong.service;

import com.atcong.Util.PlaneFindDetils;
import com.atcong.entity.PlaneInfoEntity;

import java.util.List;

public interface PlaneService {
    /**
     * 添加一个plane基本信息
     * @return
     */
    void addPlane(Integer planeId,String planeName,Integer route);

    /**
     * 根据plane名删除一个地铁信息
     * @return
     */
    void removePlane(String planeName);

    /**
     * 修改一个plane信息
     * @return
     */
    void modifyPlane(PlaneInfoEntity plane);

    /**
     * 根据plane查找一个地铁信息
     * @return
     */
    PlaneInfoEntity findPlane(String planeName);

    /**
     * 查找所有plane
     * @return
     */
    List<PlaneInfoEntity> findall();

    /**
     * 查找所有plane，路线显示路线名
     */
    List<?> findAll();

    /**
     * 按要求查找plane
     */
    List<?> findAll(String planeName);

    /**
     * find all plane by plane_route
     */
    List<PlaneInfoEntity> findAll(Integer route);

    List<PlaneFindDetils> findAllPlaneDetails(String routeName);

    /**
     * find all plane by datetime
     */
    List<PlaneFindDetils> findAllPlane(String datetime,String routeName);
}
