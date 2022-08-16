package com.uteq.app.app_smart_pills_dispenser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uteq.app.app_smart_pills_dispenser.models.Pill;
import com.uteq.app.app_smart_pills_dispenser.services.PillService;
import com.uteq.app.app_smart_pills_dispenser.utils.Apis;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PillActivity extends AppCompatActivity {
    PillService pillService;
    EditText txtPillDescription;
    EditText txtPillName;

    Button save;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pill);

        txtPillName = findViewById(R.id.txtPillName);
        txtPillDescription = findViewById(R.id.txtPillDescription);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        save = findViewById(R.id.btnPillSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pill pill = new Pill();
                pill.setName(txtPillName.getText().toString());
                pill.setDescription(txtPillDescription.getText().toString());
                pill.setState((true));
                addPill(pill);

            }
        });
    }
    public void addPill(Pill pill)
    {
        pillService = Apis.getPillService();
        Call<Pill> call = pillService.addPill(pill);

        call.enqueue(new Callback<Pill>() {
            @Override
            public void onResponse(Call<Pill> call, Response<Pill> response) {
                if(response!=null) {
                    Toast.makeText(PillActivity.this, "Se registró con éxito",Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<Pill> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });
    }
}