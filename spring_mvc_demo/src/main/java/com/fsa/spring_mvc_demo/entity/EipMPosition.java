package com.fsa.spring_mvc_demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(schema = "JSFW_L_A101",name = "eip_m_position")
public class EipMPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name")
    private String positonName;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "eipMPosition" ,cascade = CascadeType.ALL)
    private List<TurbineUser> turbineUserList;
}
