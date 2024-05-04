package com.fsa.spring_mvc_demo.service;

import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.model.TurbineUserDTO;
import com.fsa.spring_mvc_demo.repository.TurbineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManagementServiceImpl implements UserManagementService{
    @Autowired
    private  TurbineUserRepository turbineUserRepository;



    @Override
    public List<TurbineUserDTO> getAllUsers() {
            List<TurbineUser> userList = turbineUserRepository.findAll();
            return userList.stream()
                    .map(userManagement -> new TurbineUserDTO(
                            userManagement.getLoginName(),
                            userManagement.getLastName(),
                            Collections.singletonList(userManagement.getDepartment())))
                    .collect(Collectors.toList());
        }


}
