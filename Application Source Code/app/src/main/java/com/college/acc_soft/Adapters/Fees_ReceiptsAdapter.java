package com.college.acc_soft.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Assignment_Model;
import com.college.acc_soft.Models.Fees_ReceiptsModel;
import com.college.acc_soft.R;

import java.util.List;

public class Fees_ReceiptsAdapter extends RecyclerView.Adapter<Fees_ReceiptsAdapter.ViewHolder> {
    Context context;
    List<Fees_ReceiptsModel> list;

    public Fees_ReceiptsAdapter(Context context, List<Fees_ReceiptsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Fees_ReceiptsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fees_receipts_listitems,parent,false);
        return new Fees_ReceiptsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Fees_ReceiptsAdapter.ViewHolder holder, int position) {
        holder.amount.setText(list.get(position).getAmount());
        holder.status.setText(list.get(position).getStatus());
        holder.voucherdate.setText(list.get(position).getVoucherdate());
        holder.vouchernum.setText(list.get(position).getVouchernum());

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Receipts Downloaded...", Toast.LENGTH_SHORT).show();
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
        TextView amount,status,voucherdate,vouchernum;
        Button download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.receipt_amount);
            status = itemView.findViewById(R.id.receipt_status);
            voucherdate = itemView.findViewById(R.id.receipt_voucher_date);
            vouchernum = itemView.findViewById(R.id.receipt_voucher_num);
            download = itemView.findViewById(R.id.fees_receipt_download);
        }
    }
}

