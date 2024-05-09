package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.model.NewUser;
import com.fsa.spring_mvc_demo.model.UserDetails;
import com.fsa.spring_mvc_demo.service.TurbineService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


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
        List<UserDetails> userDetailList = turbineService.getAllUserDetails();
        model.addAttribute("userDetailList", userDetailList);
        return "searchUser";
    }

    @GetMapping("/form")
    public String addUserForm(Model model) {
        model.addAttribute("newUser", new NewUser());
        return "addUser";
    }

//    @PostMapping("/create")
//    public String addUser(@ModelAttribute NewUser newUser, Model model) {
//        model.addAttribute("newUser", new NewUser());
//        turbineService.addUser(newUser);
//        System.out.println(newUser);
//        return "addUser";
//    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute NewUser newUser, Model model) {
        try {
            turbineService.addUser(newUser);
            model.addAttribute("message", "User added successfully");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("newUser", new NewUser());
        return "addUser";
    }

    @GetMapping("/list")
    public List<UserDetails> showUserDetails(Model model) {
        List<UserDetails> userDetailList = turbineService.getAllUserDetails();
        model.addAttribute("userDetailList", userDetailList);
        return userDetailList;
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeSelectedUser(@RequestBody List<String> selectedUsers) {
        try {
            if (selectedUsers != null && !selectedUsers.isEmpty()) {
                turbineService.removeUser(selectedUsers);
                return ResponseEntity.ok("Users removed successfully");
            } else {
                return ResponseEntity.badRequest().body("No user selected for removal");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error removing users: " + e.getMessage());
        }
    }

}
