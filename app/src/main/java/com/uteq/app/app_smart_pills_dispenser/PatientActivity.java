package com.uteq.app.app_smart_pills_dispenser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uteq.app.app_smart_pills_dispenser.models.Carer;
import com.uteq.app.app_smart_pills_dispenser.models.Patient;
import com.uteq.app.app_smart_pills_dispenser.services.PatientService;
import com.uteq.app.app_smart_pills_dispenser.utils.Apis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientActivity extends AppCompatActivity {

    PatientService service;

    EditText txtname;
    Spinner  spinerGenderPatient;
    EditText txtbirthdate;
    EditText txtpassword;
    EditText txtRepeatPassword;
    String genero;

    String [] generos = {"Male", "Femelale", "No binary"};

    Button btnBack;
    Button save;
    Button btnClean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        txtname = findViewById(R.id.txtNamePatient);
        txtbirthdate = findViewById(R.id.txtBirthDatePatient);
        spinerGenderPatient = (Spinner) findViewById(R.id.spinerGenderPatient);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,R.array.combo_gender, android.R.layout.simple_spinner_item);

        spinerGenderPatient.setAdapter(adapter);
        spinerGenderPatient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                genero = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtpassword = findViewById(R.id.txtpassword);
        txtRepeatPassword = findViewById(R.id.txtrepeatPassword);



        save = findViewById(R.id.btnSavePatient);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Patient p = new Patient();
                p.setName(txtname.getText().toString());
                p.setBirth_date(txtbirthdate.getText().toString());
                p.setGender(genero);
                p.setState((true));

                addPatient(p);


            }
        });

        btnBack = findViewById(R.id.btnBackPatient);

    }

    public void addPatient(Patient p)
    {
        service = Apis.getPatientService();
        Call<Patient> call = service.addPatient(p);

        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                if(response!=null) {
                    Toast.makeText(PatientActivity.this, "Successful registration.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });
    }



}
