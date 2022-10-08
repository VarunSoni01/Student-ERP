package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Current_Backlog_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Current_Backlog_Adapter extends RecyclerView.Adapter<Current_Backlog_Adapter.ViewHolder> {
    Context context;

    public Current_Backlog_Adapter(Context context, List<Current_Backlog_Model> list) {
        this.context = context;
        this.list = list;
    }

    List<Current_Backlog_Model>list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_backlog_listitems,parent,false);
        return new Current_Backlog_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub.setText(list.get(position).getSubject());
        holder.sem.setText(list.get(position).getSem());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sub,sem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.backlog_sub);
            sem = itemView.findViewById(R.id.backlog_sem);
        }
    }
}
