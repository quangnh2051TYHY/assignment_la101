package com.fsa.spring_mvc_demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TurbineUserDTO {
    private String loginName;
    private String lastName;
    private List<String> department;

    public TurbineUserDTO(String loginName, String lastName, List<String> department) {
        this.loginName = loginName;
        this.lastName = lastName;
        this.department = department;
    }
}
