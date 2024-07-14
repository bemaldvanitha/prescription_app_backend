package com.bemal.prescription_app.Dto;

public class SavePrescriptionResponse {

    private String message;

    private String url;


    public SavePrescriptionResponse() {
    }

    public SavePrescriptionResponse(String message, String url) {
        this.message = message;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SavePrescriptionResponse{" +
                "message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
