package com.coursework.demo.dto;

import com.coursework.demo.entity.Provider;
import com.coursework.demo.entity.Seller;
import lombok.Data;

@Data
public class GoodDTO {
    private long id;

    private String name;

    private long price;

    private long profit;

    private long weight;

    private long quantity;

    private Seller seller;

    private Provider provider;
}
