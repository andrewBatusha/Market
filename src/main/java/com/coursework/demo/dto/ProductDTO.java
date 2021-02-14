package com.coursework.demo.dto;

import com.coursework.demo.entity.Building;
import com.coursework.demo.entity.Producer;
import lombok.Data;

@Data
public class ProductDTO {

    private long id;

    private String name;

    private long price;

    private long weight;

    private long quantity;

    private Producer producer;

    private Building building;

}
