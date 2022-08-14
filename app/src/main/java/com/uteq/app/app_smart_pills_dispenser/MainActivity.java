package com.uteq.app.app_smart_pills_dispenser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.uteq.app.app_smart_pills_dispenser.models.Dosage;
import com.uteq.app.app_smart_pills_dispenser.services.DosageService;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    DosageService dosageService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listDosage()
    {
        Call<List<Dosage>> call = dosageService.getDosage();
    }
}