package com.college.acc_soft.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Fragments.Current_BacklogFragment;
import com.college.acc_soft.Fragments.Upload_AssignmentFragment;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.List;

public class Admin_Panel_Adapter extends RecyclerView.Adapter<Admin_Panel_Adapter.ViewHolder> {
    Context context;
    List<General_InfoModel>list;
    FragmentTransaction transaction;

    public Admin_Panel_Adapter(Context context, List<General_InfoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_info_list,parent,false);
        return new Admin_Panel_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getText());
        holder.imageView.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textnames);
            imageView = itemView.findViewById(R.id.images);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    switch (pos){
                        case 0:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Upload_AssignmentFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;
                    }
                }
            });

        }

    }
}
