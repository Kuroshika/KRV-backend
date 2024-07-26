package com.kuka.krv.service;

import com.kuka.krv.dto.NewSubmissionDTO;
import com.kuka.krv.dto.SubmissionDTO;
import com.kuka.krv.entity.Submission;

import java.util.List;

public interface SubmissionService {
    Submission createSubmission(NewSubmissionDTO submissionDTO);
    void delSubmission(Long id);
    Submission updateSubmission(Long id, SubmissionDTO submissionDTO);
    List<Submission> getAllSubmission();
}
