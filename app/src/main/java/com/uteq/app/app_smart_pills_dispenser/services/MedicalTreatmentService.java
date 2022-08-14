package com.uteq.app.app_smart_pills_dispenser.services;

import com.uteq.app.app_smart_pills_dispenser.models.MedicalTreatment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MedicalTreatmentService {
    @GET("api/medical-treatment")
    Call<List<MedicalTreatment>> getMedicalTreatment();

    @POST("api/medical-treatment")
    Call<MedicalTreatment>addMedicalTreatment(@Body MedicalTreatment medicalTreatment);
}
