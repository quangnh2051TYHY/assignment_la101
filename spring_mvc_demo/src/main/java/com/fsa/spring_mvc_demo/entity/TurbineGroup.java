package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "turbine_group")
public class TurbineGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    private String objectdata;

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "group_alias_name")
    private String groupAliasName;

    @Column(name = "public_flag")
    private String publicFlag;

    @OneToOne(mappedBy = "group")
    private eipMPost post;
}