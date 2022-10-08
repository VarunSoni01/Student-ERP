package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.News_Notice_Model;
import com.college.acc_soft.R;

import java.util.List;

public class News_Notice_Adapter extends RecyclerView.Adapter<News_Notice_Adapter.ViewHolder> {
    Context context;
    List<News_Notice_Model>list;

    public News_Notice_Adapter(Context context, List<News_Notice_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_notice_listitems,parent,false);
        return new News_Notice_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub.setText(list.get(position).getSub());
        holder.desc.setText(list.get(position).getDesc());
        holder.date.setText(list.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sub,desc,date,download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.news_notice_sub);
            desc = itemView.findViewById(R.id.news_notice_desc);
            date = itemView.findViewById(R.id.news_notice_date);
            download = itemView.findViewById(R.id.news_notice_download);
        }
    }
}
