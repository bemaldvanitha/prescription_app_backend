package com.bemal.prescription_app.Dto;


import java.util.Date;

public class PrescriptionAnalyticResponse {

    private Long id;

    private Integer count;

    private Date data;

    public PrescriptionAnalyticResponse() {
    }

    public PrescriptionAnalyticResponse(Long id, Integer count, Date data) {
        this.id = id;
        this.count = count;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}