package com.fsa.spring_mvc_demo.repository;

import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.model.TurbineUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurbineUserRepository extends JpaRepository<TurbineUser, Integer> {
}
