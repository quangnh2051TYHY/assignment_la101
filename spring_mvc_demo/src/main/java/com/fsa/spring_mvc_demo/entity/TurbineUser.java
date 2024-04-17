package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "turbine_user")
public class TurbineUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password_value")
    private String passwordValue;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "confirm_value")
    private String confirmValue;

    private LocalDate modified;

    private LocalDate created;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    private String disabled;

    private String objectdata;

    @Column(name = "password_changed")
    private String passwordChanged;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private EipMCompany company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private EipMPosition position;

    @Column(name = "in_telephone")
    private String inTelephone;

    @Column(name = "out_telephone")
    private String outTelephone;

    @Column(name = "cellular_phone")
    private String cellularPhone;

    @Column(name = "cellular_mail")
    private String cellularMail;

    @Column(name = "cellular_uid")
    private String cellularUID;

    @Column(name = "first_name_kana")
    private String firstNameKana;

    @Column(name = "last_name_kana")
    private String lastNameKana;

    private String photo;

    @Column(name = "has_photo")
    private String hasPhoto;

    @Column(name = "photo_modified")
    private String photoModified;

    @Column(name = "photo_smartphone")
    private String photoSmartphone;

    @Column(name = "has_photo_smartphone")
    private String hasPhotoSmartphone;

    @Column(name = "photo_modified_smartphone")
    private String photoModifiedSmartphone;

    @Column(name = "tutorial_forbid")
    private String tutorialForbid;

    @Column(name = "migrate_version")
    private String migrateVersion;

    @Column(name = "created_user_id")
    private Integer createdUserId;

    @Column(name = "updated_user_id")
    private Integer updatedUserId;
}