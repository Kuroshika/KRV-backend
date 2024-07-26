package com.kuka.krv.service.impl;

import com.kuka.krv.dto.NewSubmissionDTO;
import com.kuka.krv.entity.Submission;
import com.kuka.krv.entity.TimeNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SubmissionServiceImplTest {
    @Autowired
    SubmissionServiceImpl submissionService;

    @Test
    void createSubmission() {
        NewSubmissionDTO newSubmissionDTO = new NewSubmissionDTO();
        newSubmissionDTO.setBaseCity("beijing");
        newSubmissionDTO.setCompanyDescribe("nope");
        newSubmissionDTO.setPosition("developer");
        newSubmissionDTO.setCompanyName("aliyun");

        Submission submission = submissionService.createSubmission(newSubmissionDTO);

    }

    @Test
    void getTimeNodeListBySubId(){
        List<TimeNode> timeNodeList =  submissionService.getTimeNodeListBySubId(23L);
        System.out.println(timeNodeList);
    }
}