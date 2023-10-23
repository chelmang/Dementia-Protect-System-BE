package com.example.backend.controller;

import com.example.backend.dto.GpsResponse;
import com.example.backend.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gps")
public class GpsController {

    private final GpsService gpsService;

    @Autowired
    public GpsController(GpsService gpsService) {
        this.gpsService = gpsService;
    }

    @GetMapping
    public ResponseEntity<List<GpsResponse>> getGpsHistory(
            @RequestParam(required = false) Integer user_id) {
        List<GpsResponse> historyList = gpsService.getGpsHistory(user_id);
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GpsResponse>> getGpsHistoryById(
            @PathVariable Integer id,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        List<GpsResponse> historyResponse = gpsService.getGpsHistoryByUserId(id, startDate, endDate);
        if (historyResponse != null && !historyResponse.isEmpty()) {
            return new ResponseEntity<>(historyResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
