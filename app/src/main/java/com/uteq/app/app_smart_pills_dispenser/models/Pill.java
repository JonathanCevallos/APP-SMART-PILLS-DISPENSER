package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pill {
    private int id;
    private String description;
    private String name;
    private Date registrationDate;
    private boolean state;
}
