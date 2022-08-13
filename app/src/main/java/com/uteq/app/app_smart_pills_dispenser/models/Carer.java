package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

public class Carer {
    private int id;
    private String email;
    private String name;
    private String password;
    private String phone_number;
    private Date registation_date;
    private boolean state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getRegistation_date() {
        return registation_date;
    }

    public void setRegistation_date(Date registation_date) {
        this.registation_date = registation_date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
