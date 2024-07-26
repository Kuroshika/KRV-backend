package com.kuka.krv.dto;

import com.kuka.krv.entity.TimeNode;
import jakarta.persistence.Column;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SubmissionDTO {

    private String companyName;
    private String companyDescribe;
    private String position;
    private String baseCity;
    private java.sql.Date submissionDate;
    private java.sql.Date updatedDate;
    private List<TimeNode> timeNodeList;

    public List<TimeNode> getTimeNodeList() {
        return timeNodeList;
    }

    public void setTimeNodeList(List<TimeNode> timeNodeList) {
        this.timeNodeList = timeNodeList;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescribe() {
        return companyDescribe;
    }

    public void setCompanyDescribe(String companyDescribe) {
        this.companyDescribe = companyDescribe;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBaseCity() {
        return baseCity;
    }

    public void setBaseCity(String baseCity) {
        this.baseCity = baseCity;
    }
}

