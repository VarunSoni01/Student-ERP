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
import com.college.acc_soft.Models.Online_Transaction_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Online_Transaction_Adapter extends RecyclerView.Adapter<Online_Transaction_Adapter.ViewHolder> {
    Context context;
    List<Online_Transaction_Model> list;

    public Online_Transaction_Adapter(Context context, List<Online_Transaction_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Online_Transaction_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_transaction_listitems,parent,false);
        return new Online_Transaction_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Online_Transaction_Adapter.ViewHolder holder, int position) {
        holder.amount.setText(list.get(position).getAmount());
        holder.status.setText(list.get(position).getStatus());
        holder.date.setText(list.get(position).getDate());

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Status Downloaded...", Toast.LENGTH_SHORT).show();
            }
        });

        if(list.get(position).getStatus().equals("Successfull")){

        }
        else if(list.get(position).getStatus().equals("Pending")){
            holder.itemView.setBackgroundTintList(context.getResources().getColorStateList(R.color.yellow));
        }
        else{
            holder.itemView.setBackgroundTintList(context.getResources().getColorStateList(R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount,status,date;
        Button download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.online_amount);
            status = itemView.findViewById(R.id.online_status);
            date = itemView.findViewById(R.id.online_trans_date);
            download = itemView.findViewById(R.id.online_download);
        }
    }
}

