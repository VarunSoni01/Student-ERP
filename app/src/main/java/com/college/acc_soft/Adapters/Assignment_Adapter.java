package com.college.acc_soft.Adapters;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import static androidx.core.app.ActivityCompat.requestPermissions;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Fragments.StudentAssignmentUploadFragment;
import com.college.acc_soft.Fragments.SyllabusFragment;
import com.college.acc_soft.MainActivity;
import com.college.acc_soft.Models.Assignment_Model;
import com.college.acc_soft.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.util.List;

public class Assignment_Adapter extends RecyclerView.Adapter<Assignment_Adapter.ViewHolder> {
    Context context;
    List<Assignment_Model>list;

    public Assignment_Adapter(Context context, List<Assignment_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_listitem,parent,false);
        return new Assignment_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subject.setText(list.get(position).getSubject());
        holder.ass_no.setText(list.get(position).getAss_no());
        holder.by.setText(list.get(position).getBy());
        holder.pub_date.setText(list.get(position).getPub_date());
        holder.up_date.setText(list.get(position).getUp_date());
        int pos = holder.getAdapterPosition();

        holder.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction;
                transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_framelayout, new StudentAssignmentUploadFragment());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(context, "Assignment Downloaded...", Toast.LENGTH_SHORT).show();
                downloadfile(context,list.get(pos).getSubject(), ".pdf", DIRECTORY_DOWNLOADS,list.get(pos).getLink());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,ass_no,by,pub_date,up_date;
        Button upload,download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.assignment_sub);
            ass_no = itemView.findViewById(R.id.assignment_no);
            by = itemView.findViewById(R.id.assignment_by);
            pub_date = itemView.findViewById(R.id.assignment_pubdate);
            up_date = itemView.findViewById(R.id.assignment_update);
            upload = itemView.findViewById(R.id.assignment_upload);
            download = itemView.findViewById(R.id.assignment_download);
        }
    }

    public void downloadfile(Context context, String filename, String fileExtension, String destinationDirectory, String url) {


        DownloadManager dmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request req = new DownloadManager.Request(uri);

        req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        req.setDestinationInExternalFilesDir(context, destinationDirectory, filename + fileExtension);
        dmanager.enqueue(req);

    }


}
