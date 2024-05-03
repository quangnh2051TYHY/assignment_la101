package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "JSFW_L_A101",name = "turbine_group")
public class TurbineGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String  groupName ;

    private String objectdata;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "group_alias_name")
    private String groupAliasName;

    @Column(name = "public_flag")
    private String publicFlag;

    @OneToOne(mappedBy = "turbineGroup",cascade = CascadeType.ALL)
     private EipMPost eipMPost;






}
