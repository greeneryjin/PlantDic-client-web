package com.example.demo.plantDic.repository;

import com.example.demo.plantDic.model.MyGardenDtl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyGardenDtlRepository extends JpaRepository<MyGardenDtl, Long>, MyGardenDtlRepositoryCustom {

    //전체 조회
    @Query("select m from MyGardenDtl m")
    List<MyGardenDtl> findMyGardenDtlByAll(Pageable pageable);

    //단 건 조회
    @Query("SELECT m from MyGardenDtl m where m.id= :id")
    List<MyGardenDtl> findByGetId(@Param("id")Long id);

    //전체 조회
    Page<MyGardenDtl> findAll(Pageable pageable);

    //국명, 영명, 학명 조회.
    @Query("SELECT m from MyGardenDtl m where m.cntntsSj like concat('%',:name,'%') or m.plntbneNm like concat('%', :name,'%') or m.plntzrNm like concat('%', :name, '%') ")
    Page<MyGardenDtl> findName(Pageable pageable, @Param("name")String name);

    @Query("SELECT m from MyGardenDtl m where m.cntntsSj like concat('%',:name,'%')")
    List<MyGardenDtl> findByName(@Param("name")String name);


}

