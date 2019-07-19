package com.atcong.dao;

import com.atcong.Util.TrainFindJson;
import com.atcong.entity.TrainInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * train_info
 */
public interface TrainDao extends JpaRepository<TrainInfoEntity,Integer> {

    @Query(value = "select * from train_info where train_name = ?1",nativeQuery = true)
    TrainInfoEntity findByTrainName(String trainName);

    @Query(value = "select * from train_info where train_id = ?1",nativeQuery = true)
    TrainInfoEntity findByTrainId(Integer trainId);

    @Query(value = "delete from train_info where train_name = ?1",nativeQuery = true)
    @Modifying
    void deleteByTrainName(String train_name);

    @Query(value = "select t.train_id,t.train_name,r.route_name from train_info t left join train_route r on t.train_route = r.route_id",nativeQuery = true)
    List<?> findAllTrainInfo();

    @Query(value = "select * from train_info where train_route = ?1",nativeQuery = true)
    List<TrainInfoEntity> findAllByTrainRoute(Integer routeId);

}
