package com.uteq.app.app_smart_pills_dispenser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uteq.app.app_smart_pills_dispenser.adapters.PatientAdapter;
import com.uteq.app.app_smart_pills_dispenser.models.Patient;
import com.uteq.app.app_smart_pills_dispenser.utils.Apis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientRcvActivity extends AppCompatActivity {

    Button btnSearch;
    Button btnAddPatient;
    Button btnViewAll;

    private RecyclerView recyclerView;
    private PatientAdapter patientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv_patient);

        recyclerView = findViewById(R.id.reciclerviewPatient);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        patientAdapter = new PatientAdapter();
        recyclerView.setAdapter(patientAdapter);




        btnSearch = findViewById(R.id.btnSearchPatient);

        btnAddPatient = findViewById(R.id.btnAddPatient);

        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PatientActivity.class);
                startActivity(intent);
            }
        });

        btnViewAll = findViewById(R.id.btnListAllPatient);

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    getpatient();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
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
}
