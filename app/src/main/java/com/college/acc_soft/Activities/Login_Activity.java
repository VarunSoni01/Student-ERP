package com.college.acc_soft.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.college.acc_soft.MainActivity;
import com.college.acc_soft.R;

public class Login_Activity extends AppCompatActivity {

    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        username = findViewById(R.id.user_id);
        password = findViewById(R.id.user_pass);
        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login_Activity.this, ""+username.getText().toString()+" , "+password.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}