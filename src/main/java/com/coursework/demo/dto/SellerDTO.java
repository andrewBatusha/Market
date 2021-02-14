package com.coursework.demo.dto;

import com.coursework.demo.entity.Building;
import lombok.Data;
import org.hibernate.type.TimeType;

@Data
public class SellerDTO {
    private long id;

    private String name;

    private String surname;

    private String patronymic;

    private TimeType timeType;

    private Building building;
}
