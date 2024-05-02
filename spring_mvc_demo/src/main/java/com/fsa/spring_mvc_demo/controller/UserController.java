package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.service.TurbineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private TurbineUserService turbineUserService;
}
