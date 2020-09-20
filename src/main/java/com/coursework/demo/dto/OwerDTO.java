package com.coursework.demo.dto;

import com.coursework.demo.entity.Seller;
import lombok.Data;

@Data
public class OwerDTO {
    private long id;

    private String name;

    private long bunkNumber;

    private long owe;

    private Seller seller;
}
