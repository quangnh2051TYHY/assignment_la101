package com.fsa.spring_mvc_demo.service;

import com.fsa.spring_mvc_demo.entity.EipMCompany;
import com.fsa.spring_mvc_demo.model.CompanyInfo;

public interface EipMCompanyService {
    CompanyInfo getOneCompanyInfo(Integer id);
}
