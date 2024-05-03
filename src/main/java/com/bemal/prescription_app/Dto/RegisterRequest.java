package com.bemal.prescription_app.Dto;

public class RegisterRequest {

    private String name;

    private String qualification;

    private String address;

    private String registrationNumber;

    private String instituteName;

    private String otherDetails;

    public RegisterRequest() {
    }

    public RegisterRequest(String name, String qualification, String address, String registrationNumber, String instituteName, String otherDetails) {
        this.name = name;
        this.qualification = qualification;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.instituteName = instituteName;
        this.otherDetails = otherDetails;
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
}
