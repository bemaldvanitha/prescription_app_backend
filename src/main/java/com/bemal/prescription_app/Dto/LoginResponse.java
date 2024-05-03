package com.bemal.prescription_app.Dto;

public class LoginResponse {
    private String jwtToken;

    private String message;

    private int statusCode;

    public LoginResponse() {
    }

    public LoginResponse(String jwtToken, String message, int statusCode) {
        this.jwtToken = jwtToken;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
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