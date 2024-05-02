package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.service.TurbineGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    @Autowired
    private TurbineGroupService turbineGroupService;
}
