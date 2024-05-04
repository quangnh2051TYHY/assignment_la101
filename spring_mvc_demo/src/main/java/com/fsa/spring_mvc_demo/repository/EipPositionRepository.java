package com.fsa.spring_mvc_demo.repository;

import com.fsa.spring_mvc_demo.entity.EipMPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EipPositionRepository extends JpaRepository<EipMPosition , Integer>{

}