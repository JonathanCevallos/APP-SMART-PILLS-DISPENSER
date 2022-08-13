package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Patient {
    private String id;
    private Date gender;
    private String name;
    private String registration_Date;
    private Boolean state;
    private int idCarer;

}
