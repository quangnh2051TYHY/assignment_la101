package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.entity.AddUser;
import com.fsa.spring_mvc_demo.service.TurbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/controller")
public class TurbineUserController {

    @Autowired
    TurbineService turbineService;

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestPart AddUser addUser, @RequestPart MultipartFile file){
        addUser.setMugShort(file);
        AddUser user = turbineService.addUser(addUser);
        ResponseEntity<AddUser> response = ResponseEntity.ok(addUser);

        return response;// TODO noi dung trang html
    }
}
