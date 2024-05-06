package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.entity.NewUser;
import com.fsa.spring_mvc_demo.service.TurbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class TurbineUserController {

    @Autowired
    TurbineService turbineService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping
    public String loadIndexPage(Model model){
        model.addAttribute("newUser", new NewUser());
        return "searchUser";
    }

    @GetMapping("/form")
    public String addUserForm(Model model) {
        model.addAttribute("newUser", new NewUser());
        return "addUser";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute NewUser newUser, Model model) {
        model.addAttribute("newUser", new NewUser());
        turbineService.addUser(newUser);
        return "addUser";
    }
}
