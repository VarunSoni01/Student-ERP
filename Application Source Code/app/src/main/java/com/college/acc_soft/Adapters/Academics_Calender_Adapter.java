package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Academics_Calender_Model;
import com.college.acc_soft.R;

import org.w3c.dom.Text;

import java.util.List;

public class Academics_Calender_Adapter extends RecyclerView.Adapter<Academics_Calender_Adapter.ViewHolder> {
    Context context;
    List<Academics_Calender_Model>list;

    public Academics_Calender_Adapter(Context context, List<Academics_Calender_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calender_list_items,parent,false);
        return new Academics_Calender_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(list.get(position).getData());
        holder.sub.setText(list.get(position).getSub());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date,sub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.holiday_day);
            sub = itemView.findViewById(R.id.holiday_sub);
        }
    }
}
