package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Attendance_SubWise_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Attendance_SubWise_Adapter extends RecyclerView.Adapter<Attendance_SubWise_Adapter.ViewHolder> {
    Context context;
    List<Attendance_SubWise_Model>list;

    public Attendance_SubWise_Adapter(Context context, List<Attendance_SubWise_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendancesub_list,parent,false);
        return new Attendance_SubWise_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub.setText(list.get(position).getSub());
        holder.pre.setText(list.get(position).getPre());
        holder.abs.setText(list.get(position).getAbs());
        holder.lea.setText(list.get(position).getLea());
        holder.na.setText(list.get(position).getNa());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pre,abs,na,lea,sub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.atdsub_subject);
            pre = itemView.findViewById(R.id.atds_pre_count);
            abs = itemView.findViewById(R.id.atds_abs_count);
            lea = itemView.findViewById(R.id.atds_leave_count);
            na = itemView.findViewById(R.id.atds_na_count);
        }
    }
}
