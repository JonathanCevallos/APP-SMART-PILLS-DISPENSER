package com.uteq.app.app_smart_pills_dispenser.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.uteq.app.app_smart_pills_dispenser.R;
import com.uteq.app.app_smart_pills_dispenser.models.Patient;
import com.uteq.app.app_smart_pills_dispenser.utils.MoreUtils;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder>  {

    private List<Patient> data = new ArrayList<>();
    private Context context;


    public PatientAdapter() {
    }

    public void setData(List<Patient> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PatientAdapter.PatientViewHolder(LayoutInflater.from(context).inflate(R.layout.carview_patient, parent, false));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient = data.get(position);

        holder.txtId.setText(MoreUtils.coalesce(patient.getName(), "N/D"));
        holder.txtNombres.setText(MoreUtils.coalesce(patient.getGender(), "N/D"));
        holder.txtArea.setText(MoreUtils.coalesce(patient.getBirthDate(), "N/D"));



    }


    public int getItemCount() {
        return data.size();
    }

    public class PatientViewHolder extends RecyclerView.ViewHolder {

        TextView txtId;
        TextView txtNombres;
        TextView txtArea;
        ImageView imgEvaluador;
        CardView cardView;


        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtId);
            txtNombres = itemView.findViewById(R.id.txtNombres);
            txtArea = itemView.findViewById(R.id.txtArea);
            imgEvaluador = itemView.findViewById(R.id.imgEvaluador);
            cardView = itemView.findViewById(R.id.cardView);
        }


    }
}
