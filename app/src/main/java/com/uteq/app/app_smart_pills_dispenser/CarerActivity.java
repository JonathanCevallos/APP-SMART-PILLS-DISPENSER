package com.uteq.app.app_smart_pills_dispenser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uteq.app.app_smart_pills_dispenser.models.Carer;
import com.uteq.app.app_smart_pills_dispenser.services.CarerService;
import com.uteq.app.app_smart_pills_dispenser.utils.Apis;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarerActivity extends AppCompatActivity {

    CarerService service;

    EditText txtname;
    EditText txtphoneNumber;
    EditText txtemail;
    EditText txtpassword;
    EditText txtRepeatPassword;

    Button save;
    Button btnClean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_carer);

        txtname = findViewById(R.id.txtname);
        txtphoneNumber = findViewById(R.id.txtphonenumber);
        txtemail = findViewById(R.id.txtemail);
        txtpassword = findViewById(R.id.txtpassword);
        txtRepeatPassword = findViewById(R.id.txtrepeatPassword);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        save = findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carer c = new Carer();
                c.setName(txtname.getText().toString());
                c.setEmail(txtemail.getText().toString());
                c.setPassword(txtpassword.getText().toString());
                c.setPhone_number(txtphoneNumber.getText().toString());
                c.setState((true));

                String pass=txtpassword.getText().toString();
                String repeatPass = txtRepeatPassword.getText().toString();
                String name =  txtname.getText().toString();
                String phone = txtphoneNumber.getText().toString();
                String email =txtemail.getText().toString();

                if(pass.equals(repeatPass) && !(pass.isEmpty() || repeatPass.isEmpty() || name.isEmpty() || phone.isEmpty() ||email.isEmpty() )) {
                    addCarer(c);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class );
                    startActivity(intent);
                }
                else if(pass.isEmpty() || repeatPass.isEmpty() || name.isEmpty() || phone.isEmpty() ||email.isEmpty() ){
                    Toast.makeText(CarerActivity.this, "Error, check the campos. " , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CarerActivity.this, "Error, check the password. " , Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnClean = findViewById(R.id.btnClean);

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtname.setText("");
                txtphoneNumber.setText("");
                txtemail.setText("");
                txtpassword.setText("");
                txtRepeatPassword.setText("");
            }
        });




    }

    public void addCarer(Carer c)
    {
        service = Apis.getCarerService();
        Call<Carer> call = service.addCarer(c);

        call.enqueue(new Callback<Carer>() {
            @Override
            public void onResponse(Call<Carer> call, Response<Carer> response) {
                if(response!=null) {
                    Toast.makeText(CarerActivity.this, "Successful registration.",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Carer> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });
    }
}
