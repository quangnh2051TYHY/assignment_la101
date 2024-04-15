package com.fsa.spring_mvc_demo.controller;

import com.fsa.spring_mvc_demo.model.UserInfor;
import com.fsa.spring_mvc_demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/get-index")
    public String loadIndexPage(Model model) {

        model.addAttribute("name", "Dat");
        UserInfor userInfo = new UserInfor();
        userInfo.setFirstName("FF");
        userInfo.setLastName("Last");
        model.addAttribute("userInfo", userInfo);
        return "index"; // View
    }

    @GetMapping("/get-index-by-model-and-view")
    public ModelAndView loadIndexPageByModelAndView() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "Son");
        return modelAndView;
    }

    @PostMapping("/saveUser")
    public String createUser(@ModelAttribute UserInfor userInfo) {
        System.out.println(userInfo);
        return "redirect:/api/get-index";
    }

    @GetMapping("/test/{id}/test1/{age}")
    public String pathVariableTest(@PathVariable(value = "id", required = false) Integer id,
                                   @RequestParam("name") String name,
                                   @PathVariable("age") Integer age,
                                   @RequestParam("address") String address) {
        System.out.println(id);
        System.out.println(name);
        return "redirect:/api/get-index";
    }
}
