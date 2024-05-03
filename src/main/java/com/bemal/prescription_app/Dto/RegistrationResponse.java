package com.bemal.prescription_app.Dto;

public class RegistrationResponse {
    private String message;

    private int statusCode;

    public RegistrationResponse() {
    }

    public RegistrationResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
