package com.example.demo.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private long id;
    private String name;
    private String address;
    private String city;
    private String pin;

    public StudentDTO(Long id, String name, String address, String city, String pin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.pin = pin;
    }

    public StudentDTO() {
        
    }
}
