package com.uteq.app.app_smart_pills_dispenser.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Doctor {
    int id;
    String direction;
    String email;
    String name;
    String phoneNumber;

}
