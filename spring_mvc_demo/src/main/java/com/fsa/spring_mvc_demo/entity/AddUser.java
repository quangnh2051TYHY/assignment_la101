package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.Column;
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
public class AddUser {
    private String loginName;
    private String password;

    private String checkPassword;

    private String firstName;

    private String lastName;

    private String firstNameFurigana;

    private String lastNameFurigana;

    private String mailAddress;

    private String telephoneNumber;

    private String telephoneNumberExtension;

    private String telephoneNumberMobile;

    private String mobileEmailAddress;

    private MultipartFile mugShort;

    private List<String> department;

    private String position;

    private boolean isadministrativePrivile;





}
