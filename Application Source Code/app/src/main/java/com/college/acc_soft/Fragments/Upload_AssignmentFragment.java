package com.college.acc_soft.Fragments;

import static android.app.Activity.RESULT_OK;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.college.acc_soft.Notification.Constants.TOPIC;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.college.acc_soft.MainActivity;
import com.college.acc_soft.Models.Assignment_Model;
import com.college.acc_soft.Notification.ApiUtilities;
import com.college.acc_soft.Notification.NoitficationData;
import com.college.acc_soft.Notification.PushNotification;
import com.college.acc_soft.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Upload_AssignmentFragment extends Fragment {
    EditText sub,no,by;
    Button submit;
    ImageView pdf;
    TextView filename;
    Uri imageuri = null;
    ProgressDialog dialog;
    DateTimeFormatter dtf;
    String date;
    String myurl;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String displayName;
    Intent galleryIntent = new Intent();


    public Upload_AssignmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload__assignment, container, false);
        sub = view.findViewById(R.id.stu_user_id);
        by = view.findViewById(R.id.assby);
        no = view.findViewById(R.id.new_ass_no);
        pdf = view.findViewById(R.id.uploadasspdf);
        submit = view.findViewById(R.id.ass_up);
        filename = view.findViewById(R.id.filename);
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        date = dtf.format(now);


        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                // We will be redirected to choose pdf
                galleryIntent.setType("application/pdf");
                startActivityForResult(galleryIntent, 1);

            }
        });




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("Assignment").add(new Assignment_Model(sub.getText().toString(),myurl,"Assignment No. "+no.getText().toString(),"Assignment by - "+by.getText().toString(),date,date)).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        PushNotification notification = new PushNotification(new NoitficationData("New Assignment",sub.getText().toString()+" new assignment has been uploaded"),TOPIC);
                        sendNotification(notification);
                    }
                });

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


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // Here we are initialising the progress dialog box
            dialog = new ProgressDialog(getContext());
            dialog.setMessage("Uploading");

            // this will show message uploading
            // while pdf is uploading
            dialog.show();
            imageuri = data.getData();
            final String timestamp = "" + System.currentTimeMillis();
            StorageReference storageReference = FirebaseStorage.getInstance().getReference();
            final String messagePushID = timestamp;
            Toast.makeText(getContext(), imageuri.toString(), Toast.LENGTH_SHORT).show();

            // Here we are uploading the pdf in firebase storage with the name of current time
            final StorageReference filepath = storageReference.child(messagePushID + "." + "pdf");
            Toast.makeText(getContext(), filepath.getName(), Toast.LENGTH_SHORT).show();
            filepath.putFile(imageuri).continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return filepath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        // After uploading is done it progress
                        // dialog box will be dismissed
                        dialog.dismiss();
                        Uri uri = task.getResult();
                        String uriString = uri.toString();
                        myurl = uri.toString();
                        File myFile = new File(uriString);
                        if (uriString.startsWith("content://")) {
                            Cursor cursor = null;
                            try {
                                cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
                                if (cursor != null && cursor.moveToFirst()) {
                                    displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                                    displayName = "Hello";
                                }
                            } finally {
                                cursor.close();
                            }
                        } else if (uriString.startsWith("file://")) {
                            displayName = myFile.getName();
                            displayName = "World";
                        }

                        filename.setText(displayName);
                        pdf.setImageResource(R.drawable.pdf_selected);

                        Toast.makeText(getContext(), "Uploaded Successfully"+myurl, Toast.LENGTH_SHORT).show();
                    } else {
                        dialog.dismiss();
                        Toast.makeText(getContext(), "UploadedFailed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



}
