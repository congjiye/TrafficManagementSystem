package com.atcong.dao;

import com.atcong.entity.TrainDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainDetailsDao extends JpaRepository<TrainDetailsEntity,Integer> {
    @Query(value = "select * from train_details where train_id = ?1",nativeQuery = true)
    TrainDetailsEntity findByTrainId(Integer trainId);
}
