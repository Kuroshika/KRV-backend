package com.kuka.krv.entity;

import com.kuka.krv.dto.NewSubmissionDTO;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "resume_submissions")
public class Submission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_describe")
    private String companyDescribe;

    @Column(name = "position")
    private String position;

    @Column(name = "base")
    private String baseCity;

    @Column(name = "submission_date")
    private java.sql.Date submissionDate;

    @Column(name = "updated_date")
    private java.sql.Date updatedDate;

    protected Submission() {

    }
    public Submission(NewSubmissionDTO submissionDTO){

    }

    public Submission(String companyName, String companyDescribe, String position, String baseCity, Date submissionDate, Date updatedDate) {
        this.companyName = companyName;
        this.companyDescribe = companyDescribe;
        this.position = position;
        this.baseCity = baseCity;
        this.submissionDate = submissionDate;
        this.updatedDate = updatedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
