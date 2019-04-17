package com.aily.shortener;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic,Integer>{
     List<Statistic> findAllByLId(int lId);
     int countByLId(int lId); 
}
