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

import com.college.acc_soft.Fragments.Fees_InstallmentFragment;
import com.college.acc_soft.Fragments.Fees_ReceiptsFragment;
import com.college.acc_soft.Fragments.News_NoticeFragment;
import com.college.acc_soft.Fragments.Online_TransactionFragment;
import com.college.acc_soft.Fragments.PayFeesFragment;
import com.college.acc_soft.Fragments.Student_LedgerFragment;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.List;

public class Pay_Fee_OnlineAdapter extends RecyclerView.Adapter<Pay_Fee_OnlineAdapter.ViewHolder> {
    Context context;
    List<General_InfoModel> list;
    FragmentTransaction transaction;

    public Pay_Fee_OnlineAdapter(Context context, List<General_InfoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Pay_Fee_OnlineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_info_list,parent,false);
        return new Pay_Fee_OnlineAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Pay_Fee_OnlineAdapter.ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getText());
        holder.imageView.setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  textView;
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
                            transaction.replace(R.id.main_framelayout, new PayFeesFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 1:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Fees_ReceiptsFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 2:
                        case 6:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Student_LedgerFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 3:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Online_TransactionFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 4:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Fees_InstallmentFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;


                        default:
                            Toast.makeText(itemView.getContext(), "Coming Soon...", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

}

