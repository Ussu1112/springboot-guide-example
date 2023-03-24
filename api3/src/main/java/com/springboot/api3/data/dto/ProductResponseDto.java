package com.springboot.api3.data.dto;

import lombok.Data;

@Data
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

}
