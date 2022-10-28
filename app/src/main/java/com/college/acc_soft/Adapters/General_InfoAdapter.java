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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Fragments.Academic_CalenderFragment;
import com.college.acc_soft.Fragments.AssignmentsFragment;
import com.college.acc_soft.Fragments.Examination_PaperFragment;
import com.college.acc_soft.Fragments.News_NoticeFragment;
import com.college.acc_soft.Fragments.PayFeesFragment;
import com.college.acc_soft.Fragments.Question_PaperFragment;
import com.college.acc_soft.Fragments.SyllabusFragment;
import com.college.acc_soft.MainActivity;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.List;

public class General_InfoAdapter extends RecyclerView.Adapter<General_InfoAdapter.ViewHolder> {
    Context context;
    List<General_InfoModel> list;
    FragmentTransaction transaction;
    String url;
    Intent intent;

    public General_InfoAdapter(Context context, List<General_InfoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_info_list,parent,false);
        return new General_InfoAdapter.ViewHolder(view);
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
                            transaction.replace(R.id.main_framelayout, new Academic_CalenderFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 2:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Examination_PaperFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 3:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new Question_PaperFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 4:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new News_NoticeFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 5:
                            transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.main_framelayout, new SyllabusFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case 6:
                            url = "http://150.129.144.226/Accsoft_PIEMR/Grievance/G_Entry_Student.aspx";
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(url));
                            context.startActivity(intent);
                            break;

                        case 7:
                            url = "http://150.129.144.226/Accsoft_PIEMR/Parents/OnlineFormsApprovalStatus.aspx";
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(url));
                            context.startActivity(intent);
                            break;


                        default:
                            Toast.makeText(itemView.getContext(), "Coming Soon...", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

}
