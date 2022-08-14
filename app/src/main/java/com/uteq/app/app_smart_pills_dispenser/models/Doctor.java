package com.uteq.app.app_smart_pills_dispenser.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Doctor {
    private int id;
    private String direction;
    private String email;
    private String name;
    private String phoneNumber;

}
