package com.springboot.api3.data.dto;

public class ChangeProductNameDto {
    public ChangeProductNameDto() {
    }

    private Long Number;
    private String Name;

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ChangeProductNameDto(Long number, String name) {
        Number = number;
        Name = name;
    }
}
