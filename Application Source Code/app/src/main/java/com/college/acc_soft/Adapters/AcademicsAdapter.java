package com.college.acc_soft.Adapters;

import android.content.Context;
import android.content.Intent;
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

import com.college.acc_soft.Fragments.AssignmentsFragment;
import com.college.acc_soft.Fragments.Attendance_StatusFragment;
import com.college.acc_soft.Fragments.Attendance_SubWiseFragment;
import com.college.acc_soft.Fragments.Class_RecordingFragment;
import com.college.acc_soft.Fragments.Current_BacklogFragment;
import com.college.acc_soft.Fragments.EOnlineTeachingFragment;
import com.college.acc_soft.Fragments.Exam_ResultFragment;
import com.college.acc_soft.Fragments.News_NoticeFragment;
import com.college.acc_soft.Fragments.Special_Leave_RequestFragment;
import com.college.acc_soft.Fragments.Time_TableFragment;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.List;

public class AcademicsAdapter extends RecyclerView.Adapter<AcademicsAdapter.ViewHolder> {
        Context context;
        List<General_InfoModel> list;
        FragmentTransaction transaction;

public AcademicsAdapter(Context context, List<General_InfoModel> list) {
        this.context = context;
        this.list = list;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_info_list,parent,false);
        return new AcademicsAdapter.ViewHolder(view);
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
                        transaction.replace(R.id.main_framelayout, new EOnlineTeachingFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 1:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Class_RecordingFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 2:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Time_TableFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 4:
                        String url = "https://assess.cocubes.com/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        context.startActivity(intent);
                        break;

                    case 5:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Exam_ResultFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 6:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Current_BacklogFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 8:
                        Toast.makeText(context, "Registeration Form Downloaded...", Toast.LENGTH_SHORT).show();
                        break;

                    case 9:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new AssignmentsFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 10:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Special_Leave_RequestFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 11:
                        Toast.makeText(context, "Data and No-Dues form Downloaded...", Toast.LENGTH_SHORT).show();
                        break;

                    case 12:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Attendance_StatusFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case 13:
                        transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_framelayout, new Attendance_SubWiseFragment());
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

