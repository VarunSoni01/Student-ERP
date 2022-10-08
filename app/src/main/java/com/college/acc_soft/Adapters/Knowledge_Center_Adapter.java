package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Knowledge_Center_Model;
import com.college.acc_soft.R;

import org.w3c.dom.Text;

import java.util.List;

public class Knowledge_Center_Adapter extends RecyclerView.Adapter<Knowledge_Center_Adapter.ViewHolder> {
    Context context;
    List<Knowledge_Center_Model>list;

    public Knowledge_Center_Adapter(Context context, List<Knowledge_Center_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.knowledge_listitems,parent,false);
        return new Knowledge_Center_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub.setText(list.get(position).getSub());
        holder.detail.setText(list.get(position).getDetail());
        holder.date.setText(list.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sub,detail,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.know_sub);
            detail = itemView.findViewById(R.id.know_detail);
            date = itemView.findViewById(R.id.know_date);
        }
    }
}
