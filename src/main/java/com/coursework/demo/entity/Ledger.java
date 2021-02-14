package com.coursework.demo.entity;

import com.coursework.demo.entity.enums.Bookkeeping;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "ledgers")
public class Ledger implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private long quantity;

    private long price;

    @Enumerated(EnumType.STRING)
    private Bookkeeping bookkeeping;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    private Product product;
}
