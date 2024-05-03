package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(schema = "JSFW_L_A101",name = "eip_m_company")
public class EipMCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compony_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_name_kana")
    private String companyNameKana;

    @Column(name = "zipcode")
    private String zipCode;

    private String address;

    private String telephone;

    @Column(name = "fax_number")
    private String faxNumber;

    private String url;

    @Column(name = "ipaddess_internal")
    private String ipaddessInternal;

    @Column(name = "port_internal")
    private String portInternal;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "eipMCompany",cascade = CascadeType.ALL)
    private List<TurbineUser> turbineUserList;

    @OneToMany(mappedBy = "eipMCompany",cascade = CascadeType.ALL)
    private List<EipMPost> eipMPostList;


}
