package com.uteq.app.app_smart_pills_dispenser.services;

import com.uteq.app.app_smart_pills_dispenser.models.Carer;
import com.uteq.app.app_smart_pills_dispenser.models.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PatientService {
    @GET("api/patient")
    Call<List<Patient>> getPatient();

    @POST("api/patient")
    Call<Patient>addPatient(@Body Patient patient);
}
