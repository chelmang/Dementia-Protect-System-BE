package com.example.backend.service;

import com.example.backend.dto.GpsResponse;

import java.util.List;

public interface GpsService {
    List<GpsResponse> getGpsHistory(Integer userId);
    List<GpsResponse> getGpsHistoryByUserId(Integer userId, String startDate, String endDate);
}
