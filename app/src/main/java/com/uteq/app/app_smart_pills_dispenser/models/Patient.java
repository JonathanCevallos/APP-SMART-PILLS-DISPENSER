package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

public class Patient {
    private String id;
    private Date gender;
    private String name;
    private String registrationDate;
    private Boolean state;
    private int idCarer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGender() {
        return gender;
    }

    public void setGender(Date gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration_date() {
        return registrationDate;
    }

    public void setRegistration_date(String registration_date) {
        this.registrationDate = registration_date;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public int getId_carer() {
        return idCarer;
    }

    public void setId_carer(int id_carer) {
        this.idCarer = id_carer;
    }
}
