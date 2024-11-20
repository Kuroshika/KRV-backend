package com.kuka.krv.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsInfoMapper {
    Integer getSubmissionCounts();

    Integer getCompletedExamsCounts();

    Integer getIncompleteExamsCounts();

    Integer getCompletedEvaluationCounts();

    Integer getIncompleteEvaluationCounts();

    Integer getRejectionCounts();
}