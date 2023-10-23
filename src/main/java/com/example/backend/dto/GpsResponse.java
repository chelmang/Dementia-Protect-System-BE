package com.example.backend.dto;

import lombok.Data;

@Data
public class GpsResponse {
    private Integer id;
    private String latitude;
    private String longitude;
    private String altitude;
    private String startDate;
    private String endDate;
}
