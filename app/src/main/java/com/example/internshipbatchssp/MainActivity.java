package com.example.internshipbatchssp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.TestOnly;

import java.time.temporal.TemporalAmount;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText email, password;
    TextView forget_password, create_account;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.main_login_button);
        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        forget_password = findViewById(R.id.main_forget_password);
        create_account = findViewById(R.id.main_create_account);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email");
                }
                else if (!email.getText().toString().matches(email_pattern)) {
                    email.setError("Enter A Valid Email");
                }
                else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
                }

                else if(password.getText().toString().length()<6){
                    password.setError("Minimum 6 Characters");
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Sucessful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
//                    Snackbar.make(view, "Login Sucessfull", Snackbar.LENGTH_SHORT).show();
                }

            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}