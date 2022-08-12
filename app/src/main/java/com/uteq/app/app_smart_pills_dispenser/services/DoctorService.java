package com.uteq.app.app_smart_pills_dispenser.services;

import com.uteq.app.app_smart_pills_dispenser.models.Doctor;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface DoctorService {
    @GET("api/doctor")
    Call<List<Doctor>> getDoctors();
}
