package com.bemal.prescription_app.Dto;

import java.util.Date;

public class PrescriptionResponse {
    private Long id;

    private Date createdAt;

    private String patientName;

    private String mobileNumber;

    private int age;

    public PrescriptionResponse() {
    }

    public PrescriptionResponse(Long id, Date createdAt, String patientName, String mobileNumber, int age) {
        this.id = id;
        this.createdAt = createdAt;
        this.patientName = patientName;
        this.mobileNumber = mobileNumber;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
