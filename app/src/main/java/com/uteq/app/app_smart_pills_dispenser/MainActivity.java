package com.uteq.app.app_smart_pills_dispenser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uteq.app.app_smart_pills_dispenser.adapters.PatientAdapter;
import com.uteq.app.app_smart_pills_dispenser.models.Dosage;
import com.uteq.app.app_smart_pills_dispenser.models.Patient;
import com.uteq.app.app_smart_pills_dispenser.services.DosageService;
import com.uteq.app.app_smart_pills_dispenser.utils.Apis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;


    private TextView txtSubtitle;
    private RecyclerView recyclerView;
    private PatientAdapter patientAdapter;
    DosageService dosageService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.reciclerview);
        txtSubtitle = findViewById(R.id.txtSubtitle);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        patientAdapter = new PatientAdapter();
        recyclerView.setAdapter(patientAdapter);


        btnRegister = findViewById(R.id.btnRegisterCarer);

        try {
            getpatient();
        } catch (Exception e) {
            e.printStackTrace();
        }

       btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CarerActivity.class);
                startActivity(intent);
            }
        });

    }


    public void getpatient() throws Exception {
        Call<List<Patient>> patientList = Apis.getPatientService().getPatient();

        patientList.enqueue(new Callback<List<Patient>>() {
            @Override
            public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                if(response.isSuccessful()){
                    List <Patient>  patients = response.body();
                    patientAdapter.setData(patients);
                }
            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {
                Log.e("faliure", t.getLocalizedMessage());
            }
        });
    }


    public void listDosage()
    {
        //Call<List<Dosage>> call =
    }
}