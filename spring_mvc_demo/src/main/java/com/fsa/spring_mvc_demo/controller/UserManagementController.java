package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.model.TurbineUserDTO;
import com.fsa.spring_mvc_demo.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserManagementController {
    @Autowired
    private  UserManagementService userManagementService;



    @GetMapping("/turbineUsers")
    public List<TurbineUserDTO> getAllTurbineUsers() {
        return userManagementService.getAllUsers();
    }
}
