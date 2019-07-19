package com.atcong.dao;

import com.atcong.entity.PlaneInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * plane_info
 */
public interface PlaneDao extends JpaRepository<PlaneInfoEntity,Integer> {

    @Query(value = "delete from plane_info where plane_name = ?1",nativeQuery = true)
    @Modifying
    void deleteByPlaneName(String planeName);

    @Query(value = "select * from plane_info where plane_name = ?1",nativeQuery = true)
    PlaneInfoEntity findByPlaneName(String planeName);

    @Query(value = "select p.plane_id,p.plane_name,r.route_name from plane_info p left join plane_route r on p.plane_route = r.route_id",nativeQuery = true)
    List<?> findAllPlane();

    @Query(value = "select * from plane_info where plane_route = ?1",nativeQuery = true)
    List<PlaneInfoEntity> findAllByPlaneRoute(Integer plane_route);

    @Query(value = "select p.plane_name,pr.route_name,pd.plane_begin_time,pd.plane_end_time from plane_info p,plane_route pr,plane_details pd where p.plane_route = pr.route_id and  p.plane_id = pd.plane_id",nativeQuery = true)
    List<?> findAllPlaneDetails();
}
