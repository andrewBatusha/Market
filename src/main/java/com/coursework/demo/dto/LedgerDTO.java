package com.coursework.demo.dto;

import com.coursework.demo.entity.Product;
import com.coursework.demo.entity.enums.Bookkeeping;
import lombok.Data;

@Data
public class LedgerDTO {
    private long id;

    private long quantity;

    private long price;

    private Bookkeeping bookkeeping;

    private Product product;

}
