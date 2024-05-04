package com.bemal.prescription_app.Dto;

public class SavePrescriptionResponse {

    private String message;

    public SavePrescriptionResponse() {
    }

    public SavePrescriptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
