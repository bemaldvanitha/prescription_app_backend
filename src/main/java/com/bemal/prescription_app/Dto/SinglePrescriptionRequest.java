package com.bemal.prescription_app.Dto;

import java.util.Date;
import java.util.List;

public class SinglePrescriptionRequest {

    private Date createdAt;

    private String patientName;

    private Date dateOfBirth;

    private int age;

    private String gender;

    private String mobileNumber;

    private String address;

    private Double height;

    private String heightUnit;

    private Double weight;

    private String weightUnit;

    private String diagnosis;

    private String patientComplains;

    private String clinicalFeatures;

    private String examination;

    private String advice;

    private String notes;

    private boolean isNoteIncluded;

    private List<SingleDrugRequest> drugs;

    public SinglePrescriptionRequest() {
    }

    public SinglePrescriptionRequest(Date createdAt, String patientName, Date dateOfBirth, int age, String gender, String mobileNumber, String address, Double height, String heightUnit, Double weight, String weightUnit, String diagnosis, String patientComplains, String clinicalFeatures, String examination, String advice, String notes, boolean isNoteIncluded, List<SingleDrugRequest> drugs) {
        this.createdAt = createdAt;
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.height = height;
        this.heightUnit = heightUnit;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.diagnosis = diagnosis;
        this.patientComplains = patientComplains;
        this.clinicalFeatures = clinicalFeatures;
        this.examination = examination;
        this.advice = advice;
        this.notes = notes;
        this.isNoteIncluded = isNoteIncluded;
        this.drugs = drugs;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPatientComplains() {
        return patientComplains;
    }

    public void setPatientComplains(String patientComplains) {
        this.patientComplains = patientComplains;
    }

    public String getClinicalFeatures() {
        return clinicalFeatures;
    }

    public void setClinicalFeatures(String clinicalFeatures) {
        this.clinicalFeatures = clinicalFeatures;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isNoteIncluded() {
        return isNoteIncluded;
    }

    public void setNoteIncluded(boolean noteIncluded) {
        isNoteIncluded = noteIncluded;
    }

    public List<SingleDrugRequest> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<SingleDrugRequest> drugs) {
        this.drugs = drugs;
    }
}
