package com.example.backend.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Gps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String latitude;
    private String longitude;
    private String altitude;
    private String startDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
