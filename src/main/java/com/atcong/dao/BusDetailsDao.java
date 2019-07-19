package com.atcong.dao;

import com.atcong.entity.BusDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusDetailsDao extends JpaRepository<BusDetailsEntity,Integer> {
}
