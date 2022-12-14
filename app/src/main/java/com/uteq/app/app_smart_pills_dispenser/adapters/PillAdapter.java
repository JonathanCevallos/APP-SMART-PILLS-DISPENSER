package com.uteq.app.app_smart_pills_dispenser.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.uteq.app.app_smart_pills_dispenser.R;
import com.uteq.app.app_smart_pills_dispenser.models.Pill;
import com.uteq.app.app_smart_pills_dispenser.utils.MoreUtils;

import java.util.ArrayList;
import java.util.List;

public class PillAdapter extends RecyclerView.Adapter<PillAdapter.PillViewHolder> {
    private Context context;
    private List<Pill> data = new ArrayList<>();

    public PillAdapter()
    {
    }

    public void setData(List<Pill> data)
    {
        this.data = data ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PillAdapter.PillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PillAdapter.PillViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_pill, parent, false));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull PillAdapter.PillViewHolder holder, int position) {
        Pill pill = data.get(position);

        holder.txtPillName.setText(MoreUtils.coalesce(pill.getName(), "N/D"));
        holder.txtPillDescription.setText(MoreUtils.coalesce(pill.getDescription(), "N/D"));
        holder.txtPillRegistrationDate.setText(MoreUtils.coalesce(pill.getRegistration_date(), "N/D"));
    }
    @Override
    public int getItemCount() {
       return data.size();
    }

    public class PillViewHolder extends RecyclerView.ViewHolder {

        TextView txtPillName;
        TextView txtPillDescription;
        TextView txtPillRegistrationDate;
        CardView cardView;


        public PillViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPillName = itemView.findViewById(R.id.txtPillName);
            txtPillDescription = itemView.findViewById(R.id.txtPillDescription);
            txtPillRegistrationDate = itemView.findViewById(R.id.txtPillRegistrationDate);
            cardView = itemView.findViewById(R.id.cardViewPill);
        }
    }
}
