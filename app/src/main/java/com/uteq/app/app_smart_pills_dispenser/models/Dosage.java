package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dosage {
    private int id;
    private Date endDate;
    private String hour;
    private int quantity;
    private Date startDate;
    private boolean state;
    private int idMedicalTreatment;
    private int idPill;
}
