package com.college.acc_soft.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Models.Nav_list_Model;
import com.college.acc_soft.R;

import java.util.Collections;
import java.util.List;

public class Nav_Adapter extends RecyclerView.Adapter<Nav_Adapter.MyViewHolder>{

    List<Nav_list_Model> list = Collections.emptyList();;
    private Context context;
    private LayoutInflater layoutInflater;

    public Nav_Adapter(Context context,List<Nav_list_Model> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.nav_drawer_items, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Nav_Adapter.MyViewHolder holder, int position) {
        Nav_list_Model current = list.get(position);
        holder.name.setText(current.getName());
        holder.image.setImageResource(current.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        View view;
        private LinearLayout layout_logout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nav_drawer_item_name);
            image = itemView.findViewById(R.id.drawer_icon);
        }
    }

}
