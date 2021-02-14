package com.coursework.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.TimeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sellers")
public class Seller implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 35, nullable = false)
    private String name;

    @Column(length = 35, nullable = false)
    private String surname;

    @Column(length = 35, nullable = false)
    private String patronymic;

    @Enumerated(EnumType.STRING)
    private TimeType timeType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private Building building;

}
