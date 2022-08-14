package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Dosage {
    private int id;
    private Date endDate;
    private String hour;
    private int quantity;
    private Date startDate;
    private boolean state;
    private int idMedicalTreatment;
    private int idPill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getIdMedicalTreatment() {
        return idMedicalTreatment;
    }

    public void setIdMedicalTreatment(int idMedicalTreatment) {
        this.idMedicalTreatment = idMedicalTreatment;
    }

    public int getIdPill() {
        return idPill;
    }

    public void setIdPill(int idPill) {
        this.idPill = idPill;
    }
}
