package com.example.backend.dto;

import lombok.Data;

@Data
public class GpsRequest {
    private Integer user_id;
    private String latitude;
    private String longitude;
    private String altitude;
    private String startDate;
    private String endDate;
}
