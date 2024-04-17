package com.fsa.spring_mvc_demo.service.impl;

import com.fsa.spring_mvc_demo.entity.EipMCompany;
import com.fsa.spring_mvc_demo.model.CompanyInfo;
import com.fsa.spring_mvc_demo.repository.EipMCompanyRepository;
import com.fsa.spring_mvc_demo.service.EipMCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EipMCompanyServiceImpl implements EipMCompanyService {

    @Autowired
    private EipMCompanyRepository eipMCompanyRepository;

    @Override
    public CompanyInfo getOneCompanyInfo(Integer id) {
        CompanyInfo companyInfo = new CompanyInfo();
        Optional<EipMCompany> eipMCompanyOptional = eipMCompanyRepository.findById(id);
        // Not found in DB
        if (eipMCompanyOptional.isEmpty()) {
            companyInfo.setName("Khong co du lieu trong DB");
            return companyInfo;
        }
        // If exist (Ton tai)
//        if (eipMCompanyOptional.isPresent()) {
//            return companyInfo;
//        }
        companyInfo.setName(eipMCompanyOptional.get().getCompanyName());
        return companyInfo;
    }

}
