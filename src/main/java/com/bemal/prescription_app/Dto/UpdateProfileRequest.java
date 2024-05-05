package com.bemal.prescription_app.Dto;

public class UpdateProfileRequest {

    private String phoneNumber;

    private String email;

    private String qualifications;

    private String address;

    private String instituteName;

    private String otherDetails;

    public UpdateProfileRequest() {
    }

    public UpdateProfileRequest(String phoneNumber, String email, String qualifications, String address, String instituteName, String otherDetails) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.qualifications = qualifications;
        this.address = address;
        this.instituteName = instituteName;
        this.otherDetails = otherDetails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
