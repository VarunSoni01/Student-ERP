package com.college.acc_soft.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Class_Recording_Model;
import com.college.acc_soft.R;

import java.util.List;

public class Class_Recording_Adapter extends RecyclerView.Adapter<Class_Recording_Adapter.ViewHolder> {
    Context context;
    List<Class_Recording_Model>list;

    public Class_Recording_Adapter(Context context, List<Class_Recording_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_recording_listitems,parent,false);

        return new Class_Recording_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub.setText(list.get(position).getSub());
        holder.topic.setText(list.get(position).getTopic());
        holder.date.setText(list.get(position).getDate());
        holder.thumbnail.setImageDrawable(context.getResources().getDrawable(R.drawable.profile_male_png));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sub,topic,date;
        ImageView thumbnail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.recording_sub);
            topic = itemView.findViewById(R.id.recording_topic);
            date = itemView.findViewById(R.id.recording_date);
            thumbnail = itemView.findViewById(R.id.recording_thumbnail);

        }
    }
}
