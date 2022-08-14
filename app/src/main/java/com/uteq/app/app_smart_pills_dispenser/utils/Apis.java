package com.uteq.app.app_smart_pills_dispenser.utils;

import com.uteq.app.app_smart_pills_dispenser.services.CarerService;
import com.uteq.app.app_smart_pills_dispenser.services.DoctorService;
import com.uteq.app.app_smart_pills_dispenser.services.DosageService;
import com.uteq.app.app_smart_pills_dispenser.services.PatientService;

public class Apis {
    public static final String URL_001="https://app-smart-pills-dispenser.herokuapp.com/";

    public static DoctorService getDoctorService()
    {
        return ClientRetrofit.getClient(URL_001).create(DoctorService.class);
    }

    public static CarerService getCarerService()
    {
        return ClientRetrofit.getClient(URL_001).create(CarerService.class);
    }

    public static PatientService getPatientService()
    {
        return ClientRetrofit.getClient(URL_001).create(PatientService.class);
    }
}
