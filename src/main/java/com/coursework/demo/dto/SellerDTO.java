package com.coursework.demo.dto;

import com.coursework.demo.entity.Building;
import com.coursework.demo.entity.enums.TimeType;
import lombok.Data;

@Data
public class SellerDTO {
    private long id;

    private String name;

    private String surname;

    private String patronymic;

    private TimeType timeType;

    private Building building;
}
