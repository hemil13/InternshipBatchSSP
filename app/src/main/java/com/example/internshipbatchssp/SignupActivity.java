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

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    EditText name, email, contact, password, confirm_password;
    TextView already_have_account;
    Button singup;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.singup_name);
        email = findViewById(R.id.singup_email);
        contact = findViewById(R.id.singup_contact);
        password = findViewById(R.id.singup_password);
        confirm_password = findViewById(R.id.singup_confirm_password);
        already_have_account = findViewById(R.id.singup_create_account);
        singup = findViewById(R.id.singup_button);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email");
                }
                else if (!email.getText().toString().matches(email_pattern)) {
                    email.setError("Enter A Valid Email");
                } else if (name.getText().toString().equals("")) {
                    name.setError("Enter Name");
                } else if (contact.getText().toString().equals("")) {
                    contact.setError("Enter Contact");
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
                    Toast.makeText(SignupActivity.this, "Signup Sucessful", Toast.LENGTH_LONG).show();
                }

            }
        });

        already_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}