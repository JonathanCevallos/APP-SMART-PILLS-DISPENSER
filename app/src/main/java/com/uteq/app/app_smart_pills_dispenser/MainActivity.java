package com.uteq.app.app_smart_pills_dispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.uteq.app.app_smart_pills_dispenser.adapters.DosageAdapter;
import com.uteq.app.app_smart_pills_dispenser.models.Dosage;
import com.uteq.app.app_smart_pills_dispenser.services.DosageService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;

    DosageService dosageService;

    List<Dosage> listDosage = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);


        btnRegister = findViewById(R.id.btnRegisterCarer);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CarerActivity.class);
                startActivity(intent);
            }
        });

    }



    public void listDosages()
    {
        Call<List<Dosage>> call = dosageService.getDosage();
        call.enqueue(new Callback<List<Dosage>>() {
            @Override
            public void onResponse(Call<List<Dosage>> call, Response<List<Dosage>> response) {
                listDosage = response.body();
                //listView.setAdapter(new DosageAdapter(MainActivity.this, R.layout.activity_main, listDosage));
            }

            @Override
            public void onFailure(Call<List<Dosage>> call, Throwable t) {
                Log.e("Error: ", t.getMessage());
            }
        });
    }
}