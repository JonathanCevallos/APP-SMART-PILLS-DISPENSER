package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

public class Dosage {
    private int id;
    private Date endDate;
    private String hour;
    private int quantity;
    private Date registrationDate;
    private Date startDate;
    private boolean state;
    private int idMedicalTreatment;
    private int idPill;
}
