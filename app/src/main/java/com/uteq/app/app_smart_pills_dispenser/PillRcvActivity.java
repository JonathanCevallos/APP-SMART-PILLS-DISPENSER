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
import com.uteq.app.app_smart_pills_dispenser.adapters.PillAdapter;
import com.uteq.app.app_smart_pills_dispenser.models.Patient;
import com.uteq.app.app_smart_pills_dispenser.models.Pill;
import com.uteq.app.app_smart_pills_dispenser.utils.Apis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PillRcvActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PillAdapter pillAdapter;

    Button btnListPill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv_pill);

        recyclerView = findViewById(R.id.reciclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        pillAdapter = new PillAdapter();
        recyclerView.setAdapter(pillAdapter);



    }

    public void getPill() throws Exception {
        Call<List<Pill>> pillList = Apis.getPillService().getPill();

        pillList.enqueue(new Callback<List<Pill>>() {
            @Override
            public void onResponse(Call<List<Pill>> call, Response<List<Pill>> response) {
                if(response.isSuccessful()){
                    List <Pill>  pills = response.body();
                    pillAdapter.setData(pills);
                }
            }

            @Override
            public void onFailure(Call<List<Pill>> call, Throwable t) {
                Log.e("faliure", t.getLocalizedMessage());
            }
        });
    }

}
