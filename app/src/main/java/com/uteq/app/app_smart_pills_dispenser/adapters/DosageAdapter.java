package com.uteq.app.app_smart_pills_dispenser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uteq.app.app_smart_pills_dispenser.R;
import com.uteq.app.app_smart_pills_dispenser.models.Dosage;

import java.util.List;

public class DosageAdapter extends ArrayAdapter<Dosage> {

    private Context context;
    private List<Dosage>dosages;
    public DosageAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Dosage> objects)
    {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.dosages = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.content_main, parent, false);

        TextView txtId = (TextView)rowView.findViewById(R.id.ID);
        TextView txtEndDate = (TextView)rowView.findViewById(R.id.endDate);
        TextView txtHour = (TextView)rowView.findViewById(R.id.hour);
        TextView txtQuantity = (TextView)rowView.findViewById(R.id.quantity);
        TextView txtStartDate = (TextView)rowView.findViewById(R.id.startDate);
        TextView txtState = (TextView)rowView.findViewById(R.id.state);
        TextView txtIdMedicalTreatment = (TextView)rowView.findViewById(R.id.idMedicalTreatment);
        TextView txtIdPill = (TextView)rowView.findViewById(R.id.idPill);

        txtId.setText(String.format("ID:%s", dosages.get(position).getId()));
        txtEndDate.setText(String.format("endDate:%s", dosages.get(position).getEndDate()));
        txtHour.setText(String.format("hour:%s", dosages.get(position).getHour()));
        txtQuantity.setText(String.format("quantity:%s", dosages.get(position).getQuantity()));
        txtStartDate.setText(String.format("startDate:%s", dosages.get(position).getStartDate()));
        //txtState.setText(String.format("state:%s", dosages.get(position).getState()));
        txtIdMedicalTreatment.setText(String.format("idMedicalTreatment:%s", dosages.get(position).getIdMedicalTreatment()));
        txtIdPill.setText(String.format("idPill:%s", dosages.get(position).getIdPill()));

        return rowView;
    }
}
