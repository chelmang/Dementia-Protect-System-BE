package com.example.backend.service.impl;

import com.example.backend.dto.GpsResponse;
import com.example.backend.model.Gps;
import com.example.backend.repository.GpsRepository;
import com.example.backend.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GpsServiceImpl implements GpsService {

    private final GpsRepository gpsRepository;

    @Autowired
    public GpsServiceImpl(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

    @Override
    public List<GpsResponse> getGpsHistory(Integer userId) {
        List<Gps> historyList = gpsRepository.findByUserId(userId);
        return historyList.stream()
                .map(this::mapGpsToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<GpsResponse> getGpsHistoryByUserId(Integer userId, String startDate, String endDate) {
        if (startDate != null && endDate != null) {
            List<Gps> historyList = gpsRepository.findByIdAndStartDateAndEndDate(userId, startDate, endDate);
            return historyList.stream()
                    .map(this::mapGpsToResponse)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    private GpsResponse mapGpsToResponse(Gps history) {
        GpsResponse response = new GpsResponse();
        response.setId(history.getId());
        response.setLatitude(history.getLatitude());
        response.setLongitude(history.getLongitude());
        response.setAltitude(history.getAltitude());
        response.setStartDate(history.getStartDate());
        response.setEndDate(history.getEndDate());
        return response;
    }
}
