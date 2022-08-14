package com.uteq.app.app_smart_pills_dispenser.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.uteq.app.app_smart_pills_dispenser.models.MedicalTreatment;

import java.util.List;

public class MedicalTreatmentAdapter extends ArrayAdapter<MedicalTreatment> {
    private Context context;
    private List<MedicalTreatment> listMedicalTreatment;
    public MedicalTreatmentAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<MedicalTreatment> objects)
    {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.listMedicalTreatment = objects;
    }
}
