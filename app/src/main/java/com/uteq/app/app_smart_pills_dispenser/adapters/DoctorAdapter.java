package com.uteq.app.app_smart_pills_dispenser.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uteq.app.app_smart_pills_dispenser.R;
import com.uteq.app.app_smart_pills_dispenser.models.Doctor;

import java.util.List;


public class DoctorAdapter extends ArrayAdapter<Doctor> {

    private Context context;
    private List<Doctor> listDoctor;

    public DoctorAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Doctor> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.listDoctor = objects;
    }


}
