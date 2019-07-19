package com.atcong.service;

import com.atcong.entity.SubwayInfoEntity;

import java.util.List;


/**
 * 都是基本信息，要是查询详细信息请联表查询
 */
public interface SubwayService {
    /**
     * 添加一个地铁基本信息
     * @return
     */
    void addSubway(String subwayName,Integer route,Integer subwayId);

    /**
     * 根据地铁名删除一个地铁信息
     * @return
     */
    void removeSubway(String subwayName);

    /**
     * 根据地铁Id删除一个地铁信息
     */
    void removeSubway(Integer subwayId);

    /**
     * 修改一个地铁信息
     * @return
     */
    void modifySubway(SubwayInfoEntity subway);

    /**
     * 修改一个地铁信息
     */
    void modifySubway(String subwayName,Integer route);

    /**
     * 根据地铁名查找一个地铁信息
     * @return
     */
    SubwayInfoEntity findSubway(String subwayName);

    /**
     * 根据地铁Id查找一个地铁信息
     */
    SubwayInfoEntity findSubway(Integer subwayId);

    /**
     * 查找所有地铁
     * @return
     */
    List<SubwayInfoEntity> findall();

    /**
     * 查找所有地铁及路线名
     */
    List<?> findAll();

    /**
     * 查询所有符合条件的地铁
     */
    List<?> findAll(String subwayName);

    /**
     * find all subway by routeId
     */
    List<SubwayInfoEntity> findAll(Integer routeId);
}
