package com.atcong.dao;

import com.atcong.entity.SubwayInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * subway_info
 */
public interface SubwayDao extends JpaRepository<SubwayInfoEntity,Integer> {

    @Query(value = "select * from subway_info where subway_name = ?1", nativeQuery = true)
    SubwayInfoEntity findBySubwayName(String subwayName);

    @Query(value = "delete from subway_info where subway_name = ?1", nativeQuery = true)
    @Modifying
    void deleteBySubwayName(String subwayName);

    @Query(value = "select * from subway_info where subway_route = ?1",nativeQuery = true)
    List<SubwayInfoEntity> findAllBySubwayRoute(Integer routeId);

    @Query(value = "select s.subway_name,s.subway_id,r.route_name from subway_info s left join subway_route r on s.subway_route = r.route_id",nativeQuery = true)
    List<?> findAllSubway();

    @Query(value = "select * from subway_info where subway_id = ?1",nativeQuery = true)
    SubwayInfoEntity findBySubwayId(Integer subway_id);

}
