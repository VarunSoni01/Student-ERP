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

import com.college.acc_soft.Models.Exam_Result_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Exam_Result_Adapter extends RecyclerView.Adapter<Exam_Result_Adapter.ViewHolder> {
    Context context;
    List<Exam_Result_Model>list;

    public Exam_Result_Adapter(Context context, List<Exam_Result_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_result_listitems,parent,false);
        return new Exam_Result_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sem.setText(list.get(position).getSemester());
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Result Downloaded...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sem;
        Button download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sem = itemView.findViewById(R.id.result_sem);
            download = itemView.findViewById(R.id.exam_result_download);
        }
    }
}
