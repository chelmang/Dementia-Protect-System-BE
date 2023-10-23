package com.example.backend.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String name;
    private String phone_number;
    private String birth;
    private String address;
    private String gender;
    private String often_place;
}
