package com.uteq.app.app_smart_pills_dispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uteq.app.app_smart_pills_dispenser.models.Dosage;
import com.uteq.app.app_smart_pills_dispenser.services.DosageService;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;

    DosageService dosageService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnRegister = findViewById(R.id.btnRegisterCarer);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CarerActivity.class);
                startActivity(intent);
            }
        });

    }



    public void listDosage()
    {
        //Call<List<Dosage>> call =
    }
}