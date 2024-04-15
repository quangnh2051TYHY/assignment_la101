package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(schema = "JSFW_L_A101",name = "eip_m_post")
public class EipMPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "zipcode")
    private String zipCode;

    private String address;

    @Column(name = "in_telephone")
    private String inTelephone;

    @Column(name = "out_telephone")
    private String outTelephone;

    @Column(name = "fax_number")
    private String faxNumber;

    private String sort;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private EipMCompany eipMCompany ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_name")
    private  TurbineGroup turbineGroup;


}
