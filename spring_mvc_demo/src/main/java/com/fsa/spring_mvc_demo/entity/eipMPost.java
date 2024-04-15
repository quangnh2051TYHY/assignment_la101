package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "eip_m_post")
public class eipMPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private eipMCompany company;

    @Column(name = "post_name")
    private String postName;

    private String zipcode;

    private String address;

    @Column(name = "in_telephone")
    private String inTelephone;

    @Column(name = "out_telephone")
    private String outTelephone;

    @Column(name = "fax_number")
    private String faxNumber;

    @OneToOne
    @JoinColumn(name = "group_name", referencedColumnName = "group_name")
    private TurbineGroup group;

    private String sort;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}