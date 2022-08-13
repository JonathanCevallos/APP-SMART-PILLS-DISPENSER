package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalTreatment {
    private int id;
    private String description;
    private boolean endDate;
    private Date startDate;
    private int idDoctor;
    private int idPatient;
}
