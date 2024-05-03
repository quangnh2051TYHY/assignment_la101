package com.fsa.spring_mvc_demo.repository;

import com.fsa.spring_mvc_demo.entity.EipMPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EipMPostRepository extends JpaRepository<EipMPost, Integer> {
}
