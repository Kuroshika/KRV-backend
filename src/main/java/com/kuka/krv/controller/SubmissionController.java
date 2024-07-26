package com.kuka.krv.controller;

import com.kuka.krv.dto.NewSubmissionDTO;
import com.kuka.krv.dto.SubmissionDTO;
import com.kuka.krv.entity.Submission;
import com.kuka.krv.entity.TimeNode;
import com.kuka.krv.service.exceptions.SubmissionNotFoundException;
import com.kuka.krv.service.impl.SubmissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubmissionController {
    @Autowired
    private SubmissionServiceImpl submissionService;

    @GetMapping("/submission/getall")
    public ResponseEntity<List<Submission>> submissionGetAll() {
        List<Submission> submissionList = submissionService.getAllSubmission();
        return ResponseEntity.ok(submissionList);

    }

    @PostMapping("/submission/add")
    public ResponseEntity<Submission> submissionAdd(@RequestBody NewSubmissionDTO submissionDTO) {
        Submission submission = submissionService.createSubmission(submissionDTO);
        return ResponseEntity.status(201).body(submission);
    }

    @DeleteMapping("/submission/del")
    public ResponseEntity<Void> submissionDelete(@RequestParam Long id) {
        submissionService.delSubmission(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/submission/update")
    public ResponseEntity<Object> updateSubmission(@RequestParam Long id, @RequestBody SubmissionDTO submissionDTO) {
        Submission updatedSubmission;
        try{
            updatedSubmission = submissionService.updateSubmission(id, submissionDTO);
        }catch (SubmissionNotFoundException submissionNotFoundException){
//            System.out.println(submissionNotFoundException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(submissionNotFoundException.getMessage());
        }
        return ResponseEntity.ok(updatedSubmission);
    }

    @PutMapping("/submission/timenode/update")
    public ResponseEntity<Object> updateTimeNodes(@RequestParam Long id, @RequestBody List<TimeNode> timeNodeList) {

        List<TimeNode> updatedTimeNodeList;
        try{
            updatedTimeNodeList = submissionService.upsertTimeNode(id, timeNodeList);
        }catch (SubmissionNotFoundException submissionNotFoundException){
//            System.out.println(submissionNotFoundException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(submissionNotFoundException.getMessage());
        }
        return ResponseEntity.ok(updatedTimeNodeList);
    }

    @GetMapping("/submission/info")
    public ResponseEntity<Void> getSubmissionInfo(){
        return null;
    }

    @GetMapping("/submission/timenode/get")
    public ResponseEntity<Object> getTimeNodeListBySubId(@RequestParam Long subId){
        List<TimeNode> timeNodeList =  submissionService.getTimeNodeListBySubId(subId);
        return ResponseEntity.ok(timeNodeList);
    }

}
