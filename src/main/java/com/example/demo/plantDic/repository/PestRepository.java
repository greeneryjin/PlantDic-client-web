package com.example.demo.plantDic.repository;

import com.example.demo.plantDic.model.Pest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PestRepository extends JpaRepository<Pest, Long> {

    @Query("select p from Pest p where p.pestCodeNm like concat('%',:pestCodeNm,'%')")
    List<Pest> findByName(@Param("pestCodeNm")String pestCodeNm);
}
