package com.bemal.prescription_app.Dto;

public class SignupRequest {
    private String phoneNumber;

    private String email;

    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String phoneNumber, String email, String password) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
