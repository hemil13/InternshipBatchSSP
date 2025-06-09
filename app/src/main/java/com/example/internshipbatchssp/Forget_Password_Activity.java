package com.example.internshipbatchssp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Forget_Password_Activity extends AppCompatActivity {

    EditText email, password, confirm_password;
    Button change_password;
    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.forget_email);
        password = findViewById(R.id.forget_password);
        confirm_password = findViewById(R.id.forget_confirm_password);
        change_password = findViewById(R.id.forget_change_password);

        change_password.setOnClickListener(new View.OnClickListener() {
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
                else if(confirm_password.getText().toString().trim().equals("")){
                    confirm_password.setError("Enter Confirm Password");
                } else if (!confirm_password.getText().toString().matches(password.getText().toString())) {
                    confirm_password.setError("Confirm Password Does Not Matches");
                }

                else{



                    Toast.makeText(Forget_Password_Activity.this, "Password Changed sucessfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Forget_Password_Activity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}