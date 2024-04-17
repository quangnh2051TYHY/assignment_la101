package com.fsa.spring_mvc_demo.controller;


import com.fsa.spring_mvc_demo.model.CompanyInfo;
import com.fsa.spring_mvc_demo.model.ErrorModel;
import com.fsa.spring_mvc_demo.service.EipMCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private EipMCompanyService eipMCompanyService;

    @GetMapping("/company/{id}")
    public ResponseEntity<String> findCompany(@PathVariable("id") Integer companyId) {
        CompanyInfo companyInfo = eipMCompanyService.getOneCompanyInfo(companyId);
//        ErrorModel errorModel = new ErrorModel();
//        if (2 > 1) {
//            errorModel.setNameErr("Please input name");
//        }
//        model.addAttribute("errorModel", errorModel);
        return ResponseEntity.ok(companyInfo.getName());
    }
}
