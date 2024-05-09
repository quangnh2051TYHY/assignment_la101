package com.fsa.spring_mvc_demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewUser {
    private String loginName;

    private String password;

    private String checkPassword;

    private String firstName;

    private String lastName;

    private String firstNameFurigana;

    private String lastNameFurigana;

    private String mailAddress;

    // telephoneNumber
    private String tel1;

    private String tel2;

    private String tel3;

    private String telephoneNumberExtension;

    // telephoneNumberMobile
    private String telMobile1;

    private String telMobile2;

    private String telMobile3;

    private String mobileEmailAddress;

    private MultipartFile mugShort;

    private String department;

    private String position;

    private boolean isAdministrativePrivile;
}
