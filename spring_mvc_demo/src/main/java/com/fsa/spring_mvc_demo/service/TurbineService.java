package com.fsa.spring_mvc_demo.service;

import com.fsa.spring_mvc_demo.model.NewUser;
import com.fsa.spring_mvc_demo.entity.TurbineUser;
import com.fsa.spring_mvc_demo.model.UserDetails;
import com.fsa.spring_mvc_demo.repository.TurbineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurbineService {
    @Autowired
    TurbineUserRepository turbineUserRepository;

    public void addUser(NewUser user) {
        TurbineUser turbineUser = new TurbineUser();

        if (isLoginNameExist(user.getLoginName())) {
            throw new IllegalArgumentException("Login name already exists");
        }

        if (!user.getPassword().equals(user.getCheckPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

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
        String department = user.getDepartment().replaceAll("\\r\\n|\\r|\\n", ", ");
        turbineUser.setDepartment(department);
        turbineUserRepository.save(turbineUser);
    }

    public List<UserDetails> getAllUserDetails() {
        List<TurbineUser> turbineUsers = turbineUserRepository.findAll();
        List<UserDetails> userDetails = new ArrayList<>();

        for (TurbineUser turbineUser : turbineUsers) {
            UserDetails userDetail = new UserDetails();
            userDetail.setLoginName(turbineUser.getLoginName());
            userDetail.setName(turbineUser.getFirstName() + " " + turbineUser.getLastName());
            userDetail.setDepartment(turbineUser.getDepartment());
            userDetails.add(userDetail);
        }

        return userDetails;
    }

    public void removeUser(List<String> loginNames) {
        for (String loginName : loginNames) {
            TurbineUser turbineUser = turbineUserRepository.findByLoginName(loginName);
            if (turbineUser != null) {
                turbineUserRepository.delete(turbineUser);
            }
        }
    }

    public boolean isLoginNameExist(String loginName) {
        TurbineUser existingUser = turbineUserRepository.findByLoginName(loginName);
        return existingUser != null;
    }
}
