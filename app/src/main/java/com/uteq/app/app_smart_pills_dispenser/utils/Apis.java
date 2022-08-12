package com.uteq.app.app_smart_pills_dispenser.utils;

import com.uteq.app.app_smart_pills_dispenser.models.Doctor;
import com.uteq.app.app_smart_pills_dispenser.services.DoctorService;

public class Apis {
    public static final String URL_001="https://app-smart-pills-dispenser.herokuapp.com/";

    public static DoctorService getDoctorService(){
        return ClientRetrofit.getClient(URL_001).create(DoctorService.class);
    }
}
