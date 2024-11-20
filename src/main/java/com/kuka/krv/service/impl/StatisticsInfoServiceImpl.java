package com.kuka.krv.service.impl;

import com.kuka.krv.dao.mapper.SqlSessionFactorySingleton;
import com.kuka.krv.dao.mapper.StatisticsInfoMapper;
import com.kuka.krv.service.StatisticsInfoService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticsInfoServiceImpl implements StatisticsInfoService {

    @Override
    public Map<String, String> getStatisticsInfo() {
        HashMap<String,String> statisticsInfoMap = new HashMap<>();
        SqlSessionFactory sqlSessionFactory = SqlSessionFactorySingleton.getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        StatisticsInfoMapper sessionMapper = session.getMapper(StatisticsInfoMapper.class);

        statisticsInfoMap.put("submissionCounts",sessionMapper.getSubmissionCounts().toString());
        statisticsInfoMap.put("incompleteEvaluationCounts",sessionMapper.getIncompleteEvaluationCounts().toString());
        statisticsInfoMap.put("completedEvaluationCounts",sessionMapper.getCompletedEvaluationCounts().toString());
        statisticsInfoMap.put("incompleteExamsCounts",sessionMapper.getIncompleteExamsCounts().toString());
        statisticsInfoMap.put("completedExamsCounts",sessionMapper.getCompletedExamsCounts().toString());
        statisticsInfoMap.put("rejectionCounts",sessionMapper.getRejectionCounts().toString());


        return statisticsInfoMap;
    }
}
