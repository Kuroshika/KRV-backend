package com.kuka.krv.dao.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsInfoMapperTest {

    @Test
    void getSubmissionCounts() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactorySingleton.getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        StatisticsInfoMapper statisticsInfoMapper = session.getMapper(StatisticsInfoMapper.class);
        Integer count = statisticsInfoMapper.getSubmissionCounts();
        System.out.println(count);
    }
}