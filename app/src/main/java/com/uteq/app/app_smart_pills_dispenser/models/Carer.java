package com.uteq.app.app_smart_pills_dispenser.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Carer {
    private int id;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private boolean state;

}
