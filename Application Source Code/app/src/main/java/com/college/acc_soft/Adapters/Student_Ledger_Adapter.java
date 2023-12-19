package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Fees_ReceiptsModel;
import com.college.acc_soft.Models.Student_Ledger_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Student_Ledger_Adapter extends RecyclerView.Adapter<Student_Ledger_Adapter.ViewHolder> {
    Context context;
    List<Student_Ledger_Model> list;

    public Student_Ledger_Adapter(Context context, List<Student_Ledger_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Student_Ledger_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_ledger_listitem,parent,false);
        return new Student_Ledger_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Student_Ledger_Adapter.ViewHolder holder, int position) {
        holder.amount.setText(list.get(position).getAmount());
        holder.status.setText(list.get(position).getStatus());
        holder.date.setText(list.get(position).getDate());
        holder.remark.setText(list.get(position).getRemark());

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ledger Downloaded...", Toast.LENGTH_SHORT).show();
            }
        });

        if(list.get(position).getStatus().equals("Debited")){
            holder.itemView.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount,status,date,remark;
        Button download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.ledger_amount);
            status = itemView.findViewById(R.id.ledger_status);
            date = itemView.findViewById(R.id.ledger_date);
            remark = itemView.findViewById(R.id.ledger_remark);

            download = itemView.findViewById(R.id.ledger_download);
        }
    }
}

