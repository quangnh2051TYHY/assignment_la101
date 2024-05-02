package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.service.EipMPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    @Autowired
    private EipMPositionService eipMPositionService;
}
