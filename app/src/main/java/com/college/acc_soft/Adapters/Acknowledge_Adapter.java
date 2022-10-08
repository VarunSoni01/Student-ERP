package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Fragments.Knowledge_CenterFragment;
import com.college.acc_soft.Fragments.News_NoticeFragment;
import com.college.acc_soft.Fragments.SyllabusFragment;
import com.college.acc_soft.Fragments.Time_TableFragment;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.sql.Time;
import java.util.List;

public class Acknowledge_Adapter extends RecyclerView.Adapter<Acknowledge_Adapter.ViewHolder> {
    Context context;
    List<General_InfoModel>list;

    public Acknowledge_Adapter(Context context, List<General_InfoModel> list) {
        this.context = context;
        this.list = list;
    }

    FragmentTransaction transaction;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_info_list,parent,false);
        return new Acknowledge_Adapter.ViewHolder(view);
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
                            transaction.replace(R.id.main_framelayout, new Knowledge_CenterFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 1:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new SyllabusFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 2:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Time_TableFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        default:
                            Toast.makeText(context,"clickeddd", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}
