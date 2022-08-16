package com.uteq.app.app_smart_pills_dispenser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PatientRcvActivity extends AppCompatActivity {

    Button btnSearch;
    Button btnAddPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv_patient);


        btnSearch = findViewById(R.id.btnSearchPatient);

        btnAddPatient = findViewById(R.id.btnAddPatient);

        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PatientActivity.class);
                startActivity(intent);
            }
        });


    }
}
