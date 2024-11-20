package com.kuka.krv.controller;

import com.kuka.krv.service.impl.StatisticsInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StatisticsInfoController {

    @Autowired
    private StatisticsInfoServiceImpl service;

    @GetMapping("/statisticsinfo")
    public ResponseEntity<Map<String, String>> getStatisticsInfo() {
        Map<String, String> statisticsInfo = service.getStatisticsInfo();
        return ResponseEntity.ok(statisticsInfo);
    }

}
