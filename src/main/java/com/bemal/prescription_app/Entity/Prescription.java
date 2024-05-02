package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "genderId")
    private Gender gender;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "address", columnDefinition = "TEXT", nullable = true)
    private String address;

    @Column(name = "height")
    private Double height;

    @ManyToOne
    @JoinColumn(name = "height_unit_id")
    private HeightUnit heightUnit;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "weight_unit_id")
    private WeightUnit weightUnit;

    @Column(name = "diagnosis", columnDefinition = "TEXT", nullable = true)
    private String diagnosis;

    @Column(name = "patient_complains", columnDefinition = "TEXT", nullable = true)
    private String patientComplains;

    @Column(name = "clinical_features", columnDefinition = "TEXT", nullable = true)
    private String clinicalFeatures;

    @Column(name = "examination", columnDefinition = "TEXT", nullable = true)
    private String examination;

    @Column(name = "advice", columnDefinition = "TEXT", nullable = true)
    private String advice;

    @Column(name = "notes", columnDefinition = "TEXT", nullable = true)
    private String notes;

    @Column(name = "is_note_included")
    private boolean isNoteIncluded;


    public Prescription() {
    }

    public Prescription(Long id, User user, Date createdAt, String patientName, Date dateOfBirth, int age, Gender gender, Long mobileNumber, String address, Double height, HeightUnit heightUnit, Double weight, WeightUnit weightUnit, String diagnosis, String patientComplains, String clinicalFeatures, String examination, String advice, String notes, boolean isNoteIncluded) {
        this.id = id;
        this.user = user;
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
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

    public HeightUnit getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(HeightUnit heightUnit) {
        this.heightUnit = heightUnit;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
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

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", patientName='" + patientName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", gender=" + gender +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", heightUnit=" + heightUnit +
                ", weight=" + weight +
                ", weightUnit=" + weightUnit +
                ", diagnosis='" + diagnosis + '\'' +
                ", patientComplains='" + patientComplains + '\'' +
                ", clinicalFeatures='" + clinicalFeatures + '\'' +
                ", examination='" + examination + '\'' +
                ", advice='" + advice + '\'' +
                ", notes='" + notes + '\'' +
                ", isNoteIncluded=" + isNoteIncluded +
                '}';
    }
}