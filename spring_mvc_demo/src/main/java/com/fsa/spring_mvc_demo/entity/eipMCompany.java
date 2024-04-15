package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "eip_m_company")
public class eipMCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_name_kana")
    private String companyNameKana;

    private String zipcode;

    private String address;

    private String telephone;

    @Column(name = "fax_number")
    private String faxNumber;

    private String url;

    private String ipaddress;

    private String port;

    @Column(name = "ipaddress_internal")
    private String ipaddressInternal;

    @Column(name = "port_internal")
    private String portInternal;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<eipMPost> postList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<TurbineUser> userList;
}