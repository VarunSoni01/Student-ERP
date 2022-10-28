package com.college.acc_soft.Fragments;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.college.acc_soft.Notification.Constants.TOPIC;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.college.acc_soft.MainActivity;
import com.college.acc_soft.Models.Assignment_Model;
import com.college.acc_soft.Notification.ApiUtilities;
import com.college.acc_soft.Notification.NoitficationData;
import com.college.acc_soft.Notification.PushNotification;
import com.college.acc_soft.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Upload_AssignmentFragment extends Fragment {
    EditText sub, date, timing;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference reference;


    public Upload_AssignmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload__assignment, container, false);
        sub = view.findViewById(R.id.ass_sub_name);
        date = view.findViewById(R.id.ass_up_date);
        timing = view.findViewById(R.id.ass_up_timing);
        submit = view.findViewById(R.id.ass_up);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!sub.getText().toString().isEmpty() && !date.getText().toString().isEmpty() && !timing.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Entered in if", Toast.LENGTH_SHORT).show();

                    reference.child("Assignment").push().setValue(new Assignment_Model(sub.getText().toString(), "sss", date.getText().toString(), "varun", timing.getText().toString(), timing.getText().toString())).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getContext(), "Completed", Toast.LENGTH_SHORT).show();
                        }

                    });

                }
                PushNotification notification = new PushNotification(new NoitficationData("New Assignment",sub.getText().toString()+" new assignment has been uploaded"),TOPIC);
                sendNotification(notification);
            }
        });

        return view;
    }

    private void sendNotification(PushNotification notification) {
        ApiUtilities.getClient().sendNotification(notification).enqueue(new Callback<PushNotification>() {
            @Override
            public void onResponse(Call<PushNotification> call, Response<PushNotification> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PushNotification> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}