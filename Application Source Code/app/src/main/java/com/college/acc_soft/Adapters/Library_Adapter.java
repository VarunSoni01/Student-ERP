package com.college.acc_soft.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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

import com.college.acc_soft.Fragments.Library_RulesFragment;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.List;

public class Library_Adapter extends RecyclerView.Adapter<Library_Adapter.ViewHolder> {
    Context context;
    List<General_InfoModel>list;

    public Library_Adapter(Context context, List<General_InfoModel> list) {
        this.context = context;
        this.list = list;
    }

    FragmentTransaction transaction;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_info_list,parent,false);
        return new Library_Adapter.ViewHolder(view);
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

                        case 3:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Library_RulesFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 4:
                            String url = "https://play.google.com/store/apps/details?id=com.refread.rgpv";
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(url));
                            context.startActivity(intent);
                            break;

                        default:
                            Toast.makeText(context, "Coming Soon...", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}
