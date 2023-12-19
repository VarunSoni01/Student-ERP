package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Attendance_Status_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Attendance_Status_Adapter extends RecyclerView.Adapter<Attendance_Status_Adapter.ViewHolder> {

    Context context;
    List<Attendance_Status_Model> list;

    public Attendance_Status_Adapter(Context context, List<Attendance_Status_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_list, parent, false);
        return new Attendance_Status_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub.setText(list.get(position).getSub());
        holder.status.setText(list.get(position).getStatus());
        holder.date.setText(list.get(position).getDate());
        holder.lec.setText(list.get(position).getLec());
        if (list.get(position).getStatus().equals("A")) {
            holder.status.setTextColor(context.getResources().getColor(R.color.darkred));
        }
        else if (list.get(position).getStatus().equals("L")) {
            holder.status.setTextColor(context.getResources().getColor(android.R.color.holo_orange_light));
        }
        else if (list.get(position).getStatus().equals("NA")) {
            holder.status.setTextColor(context.getResources().getColor(android.R.color.holo_blue_dark));
        }
        else{
            holder.status.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sub, status, lec, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.atd_sub);
            status = itemView.findViewById(R.id.atd_status);
            lec = itemView.findViewById(R.id.atd_lec_count);
            date = itemView.findViewById(R.id.atd_curr_date);
        }
    }
}
