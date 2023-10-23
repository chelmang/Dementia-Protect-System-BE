package com.example.backend.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone_number;
    private String birth;
    private String address;
    private String gender;
    private String often_place;
}
