package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "institute_name")
    private String instituteName;

    @Column(name = "other_details", columnDefinition = "TEXT")
    private String otherDetails;

    public User() {
    }

    public User(Long id, Long phoneNumber, String email, String password, String name, String qualification, String address, String registrationNumber, String instituteName, String otherDetails) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.name = name;
        this.qualification = qualification;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.instituteName = instituteName;
        this.otherDetails = otherDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", address='" + address + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", instituteName='" + instituteName + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}