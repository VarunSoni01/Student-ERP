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

import com.college.acc_soft.Models.E_Online_Teaching_Model;
import com.college.acc_soft.Models.Fees_ReceiptsModel;
import com.college.acc_soft.R;

import java.util.List;

public class E_Online_Teaching_Adapter extends RecyclerView.Adapter<E_Online_Teaching_Adapter.ViewHolder> {
    Context context;
    List<E_Online_Teaching_Model> list;

    public E_Online_Teaching_Adapter(Context context, List<E_Online_Teaching_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public E_Online_Teaching_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.e_online_teaching_listitems,parent,false);
        return new E_Online_Teaching_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull E_Online_Teaching_Adapter.ViewHolder holder, int position) {
        holder.subject.setText(list.get(position).getSubject());
        holder.time.setText(list.get(position).getTiming());
        holder.date.setText(list.get(position).getDate());

        holder.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Meeting Joining...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,time,date;
        Button join;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.teaching_subject);
            time = itemView.findViewById(R.id.teaching_timing);
            date = itemView.findViewById(R.id.teaching_date);
            join = itemView.findViewById(R.id.teaching_join);
        }
    }
}

