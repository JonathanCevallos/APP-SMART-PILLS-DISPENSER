package com.uteq.app.app_smart_pills_dispenser;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    ImageView imgPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgPatient = findViewById(R.id.imgPatient);

        imgPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //        imgPatient.setBackgroundColor(Color.rgb(100, 100, 50));
                Intent intent = new Intent(getApplicationContext(), PatientRcvActivity.class);
                startActivity(intent);
            }
        });





    }
}
