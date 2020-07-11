package com.cakefactory.app.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDTO {

    final private String name;
    final private BigDecimal price;

}