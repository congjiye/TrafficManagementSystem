package com.atcong.dao;

import com.atcong.Util.BusFindJson;
import com.atcong.entity.BusInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *  公交车信息Dao层
 *  bus_info
 */
public interface BusDao extends JpaRepository<BusInfoEntity,Integer> {

    @Query(value = "delete from bus_info where bus_name=?1",nativeQuery = true)
    @Modifying
    void deleteByBusName(String bus_name);

    @Query(value = "select * from bus_info where bus_name=?1",nativeQuery = true)
    BusInfoEntity findByBusName(String bus_name);

    @Query(value = "select b.bus_id,b.bus_name,r.route_name from bus_info b left join bus_route r on b.route_id = r.route_id",nativeQuery = true)
    List<?> findAllBus();

    @Query(value = "select * from bus_info where route_id = ?1",nativeQuery = true)
    List<BusInfoEntity> findAllByRouteId(Integer route_id);

    @Query(value = "select b.bus_name,br.route_name,bd.bus_pay from bus_info b,bus_route br ,bus_details bd where b.bus_id = bd.bus_id and  b.route_id = br.route_id",nativeQuery = true)
    List<?> findAllByBusName();
}
