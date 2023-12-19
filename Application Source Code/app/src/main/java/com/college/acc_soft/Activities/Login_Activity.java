package com.college.acc_soft.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.college.acc_soft.MainActivity;
import com.college.acc_soft.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login_Activity extends AppCompatActivity {

    EditText username, password;
    Button login;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        username = findViewById(R.id.user_id);
        password = findViewById(R.id.user_pass);
        login = findViewById(R.id.login_btn);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("")) {
                    Toast.makeText(Login_Activity.this, "Please Enter Valid Username", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(Login_Activity.this, "please Enter Valid Password", Toast.LENGTH_SHORT).show();
                } else {
                    auth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login_Activity.this, Objects.requireNonNull(task.getException()).toString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });


    }


}