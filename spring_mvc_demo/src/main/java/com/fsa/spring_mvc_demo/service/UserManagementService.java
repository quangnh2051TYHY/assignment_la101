package com.fsa.spring_mvc_demo.service;

import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.model.TurbineUserDTO;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserManagementService {
    List<TurbineUserDTO> getAllUsers();
}
