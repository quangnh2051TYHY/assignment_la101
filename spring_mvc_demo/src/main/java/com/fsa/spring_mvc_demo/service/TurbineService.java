package com.fsa.spring_mvc_demo.service;

import com.fsa.spring_mvc_demo.entity.AddUser;
import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.repository.TurbineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

@Service
public class TurbineService {
    @Autowired
    TurbineUserRepository turbineUserRepository;

    public AddUser addUser(AddUser addUser){
        TurbineUser turbineUser = new TurbineUser();
        turbineUser.setLoginName(addUser.getLoginName());
        turbineUser.setPasswordValue(addUser.getPassword());
        turbineUser.setPasswordChanged(addUser.getCheckPassword());
        turbineUser.setFirstName(addUser.getFirstName());
        turbineUser.setLastName(addUser.getLastName());
        turbineUser.setFirstNameKana(addUser.getFirstNameFurigana());
        turbineUser.setLastNameKana(addUser.getLastNameFurigana());
        turbineUser.setEmail(addUser.getMailAddress());
        turbineUser.setInTelephone(addUser.getTelephoneNumber());
        turbineUser.setOutTelephone(addUser.getTelephoneNumberExtension());
        turbineUser.setCellularPhone(addUser.getTelephoneNumberMobile());
        turbineUser.setCellularMail(addUser.getMailAddress());
        String department = "";
        if (!CollectionUtils.isEmpty(addUser.getDepartment())) {
            department = String.join(",", addUser.getDepartment());
        }
        turbineUser.setDepartment(department);
        turbineUserRepository.save(turbineUser);

        return addUser;
    }
}
