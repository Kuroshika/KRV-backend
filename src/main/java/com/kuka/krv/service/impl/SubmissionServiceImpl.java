package com.kuka.krv.service.impl;

import com.kuka.krv.dao.TimeNodeRepository;
import com.kuka.krv.dto.NewSubmissionDTO;
import com.kuka.krv.dto.SubmissionDTO;
import com.kuka.krv.entity.Submission;
import com.kuka.krv.dao.SubmissionRepository;
import com.kuka.krv.entity.TimeNode;
import com.kuka.krv.service.SubmissionService;
import com.kuka.krv.service.exceptions.SubmissionNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private TimeNodeRepository timeNodeRepository;

    @Override
    public Submission createSubmission(NewSubmissionDTO submissionDTO) {

        LocalDate currentDate = LocalDate.now();
        java.sql.Date currentSqlDate = java.sql.Date.valueOf(currentDate);

        Submission submission = new Submission(
                submissionDTO.getCompanyName(),
                submissionDTO.getCompanyDescribe(),
                submissionDTO.getPosition(),
                submissionDTO.getBaseCity(),
                currentSqlDate,
                currentSqlDate);

        submissionRepository.save(submission);

        TimeNode startTimeNode = new TimeNode();
        startTimeNode.setNodeName("开始投递");
        startTimeNode.setComments("");
        startTimeNode.setState(1);
        startTimeNode.setFinishDate(currentSqlDate);
        startTimeNode.setNodeOrder(0);
        startTimeNode.setSubId(submission.getId());
        timeNodeRepository.save(startTimeNode);

        return submission;
    }

    @Override
    @Transactional
    public void delSubmission(Long id) {
        submissionRepository.deleteById(id);
        timeNodeRepository.deleteUsersBySubId(id);
    }

    @Override
    public Submission updateSubmission(Long id, SubmissionDTO submissionDTO) throws SubmissionNotFoundException{
        Optional<Submission> existingSubmissionOptional = submissionRepository.findById(id);

        if (!existingSubmissionOptional.isPresent()) {
            throw new SubmissionNotFoundException("User not found with ID: " + id);
        }
        Submission existingSubmission = existingSubmissionOptional.get();

        existingSubmission.setCompanyName(submissionDTO.getCompanyName());
        existingSubmission.setCompanyDescribe(submissionDTO.getCompanyDescribe());
        existingSubmission.setPosition(submissionDTO.getPosition());
        existingSubmission.setBaseCity(submissionDTO.getBaseCity());
        existingSubmission.setSubmissionDate(submissionDTO.getSubmissionDate());
        java.sql.Date currentSqlDate = java.sql.Date.valueOf(LocalDate.now());
        existingSubmission.setUpdatedDate(currentSqlDate);


        submissionRepository.save(existingSubmission);

        return existingSubmission;
    }

    public List<TimeNode> upsertTimeNode(Long id, List<TimeNode> timeNodeListDTO){
        List<TimeNode> timeNodeList  = timeNodeRepository.findAllBySubId(id);
        if (timeNodeList==null) {
            throw new SubmissionNotFoundException("No time nodes information " + id);
        }

        Collections.sort(timeNodeList);
        Collections.sort(timeNodeListDTO);

        if(timeNodeList.size()>timeNodeListDTO.size()){
            int maxSize = timeNodeList.size();
            int minSize = timeNodeListDTO.size();
            for(int i=0;i<maxSize;i++){
                if(i<minSize){
                    TimeNode oldTimeNode = timeNodeList.get(i);
                    TimeNode newTimeNode = timeNodeListDTO.get(i);
                    oldTimeNode.setNodeName(newTimeNode.getNodeName());
                    oldTimeNode.setState(newTimeNode.getState());
                    oldTimeNode.setComments(newTimeNode.getComments());
                    oldTimeNode.setFinishDate(newTimeNode.getFinishDate());
                    timeNodeRepository.save(oldTimeNode);
                }else {
                    TimeNode delTimeNode = timeNodeList.get(i);
                    timeNodeRepository.deleteById(delTimeNode.getNodeId());
                }
            }
        }else {
            int minSize = timeNodeList.size();
            int maxSize = timeNodeListDTO.size();
            for(int i=0;i<maxSize;i++){
                if(i<minSize){
                    TimeNode oldTimeNode = timeNodeList.get(i);
                    TimeNode newTimeNode = timeNodeListDTO.get(i);
                    oldTimeNode.setNodeName(newTimeNode.getNodeName());
                    oldTimeNode.setState(newTimeNode.getState());
                    oldTimeNode.setComments(newTimeNode.getComments());
                    oldTimeNode.setFinishDate(newTimeNode.getFinishDate());
                    timeNodeRepository.save(oldTimeNode);
                }else {
                    TimeNode newTimeNode = timeNodeListDTO.get(i);
                    timeNodeRepository.save(newTimeNode);
                }
            }
        }

        return timeNodeList;

    }

    @Override
    public List<Submission> getAllSubmission() {
        List<Submission> submissionList = submissionRepository.findAll();
        return submissionList;
    }

    public ArrayList<TimeNode> updateTimeNodes(Long id, List<TimeNode> timeNodeList){
        return null;
    }

    public List<TimeNode> getTimeNodeListBySubId(Long subId){
        List<TimeNode> timeNodeList =   timeNodeRepository.findAllBySubId(subId);
        return timeNodeList;
    }
}
