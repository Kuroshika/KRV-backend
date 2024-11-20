package com.kuka.krv.service.impl;

import com.kuka.krv.service.StatisticsInfoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsInfoServiceImplTest {

    @Test
    void getStatisticsInfo() {
        StatisticsInfoServiceImpl service = new StatisticsInfoServiceImpl();
        System.out.println(service.getStatisticsInfo().toString());
    }
}