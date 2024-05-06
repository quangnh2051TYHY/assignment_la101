package com.fsa.spring_mvc_demo.service;

import com.fsa.spring_mvc_demo.entity.NewUser;
import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.repository.TurbineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class TurbineService {
    @Autowired
    TurbineUserRepository turbineUserRepository;

    public NewUser addUser(NewUser user){
        TurbineUser turbineUser = new TurbineUser();
        turbineUser.setLoginName(user.getLoginName());
        turbineUser.setPasswordValue(user.getPassword());
        turbineUser.setPasswordChanged(user.getCheckPassword());
        turbineUser.setFirstName(user.getFirstName());
        turbineUser.setLastName(user.getLastName());
        turbineUser.setFirstNameKana(user.getFirstNameFurigana());
        turbineUser.setLastNameKana(user.getLastNameFurigana());
        turbineUser.setEmail(user.getMailAddress());
        turbineUser.setInTelephone(user.getTel1() + user.getTel2() + user.getTel3());
        turbineUser.setOutTelephone(user.getTelephoneNumberExtension());
        turbineUser.setCellularPhone(user.getTelMobile1() + user.getTelMobile2() + user.getTelMobile3());
        turbineUser.setCellularMail(user.getMailAddress());
        String department = "";
        if (!CollectionUtils.isEmpty(user.getDepartment())) {
            department = String.join(",", user.getDepartment());
        }
        turbineUser.setDepartment(department);
        turbineUserRepository.save(turbineUser);

        return user;
    }
}
