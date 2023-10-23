package com.example.backend.repository;

import com.example.backend.model.Gps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GpsRepository extends JpaRepository<Gps, Integer> {
    List<Gps> findByUserId(Integer userId);
    List<Gps> findByIdAndStartDateAndEndDate(Integer userId, String startDate, String endDate);
}
