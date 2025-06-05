package com.example.internshipbatchssp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    ImageView hideIV, showIV;


    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("InternshipBatchSSP.db", MODE_PRIVATE, null);
        String userTable = "CREATE TABLE IF NOT EXISTS user(userid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(100), contact VARCHAR(15), password VARCHAR(20))";
        db.execSQL(userTable);

        login = findViewById(R.id.main_login_button);
        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        forget_password = findViewById(R.id.main_forget_password);
        create_account = findViewById(R.id.main_create_account);
        hideIV = findViewById(R.id.main_hide);
        showIV = findViewById(R.id.main_show);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Enter Email Or Conatct");
                }

                else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
                }
                else if(password.getText().toString().length()<6){
                    password.setError("Minimum 6 Characters");
                }
                else{
                    String checkUser = "SELECT * FROM user WHERE (email = '"+email.getText().toString()+"' OR contact = '"+email.getText().toString()+"' ) AND password = '"+password.getText().toString()+"'";
                    Cursor cursor = db.rawQuery(checkUser, null);
                    if(cursor.getCount()>0){
                        Toast.makeText(MainActivity.this, "Login Sucessful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
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

        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Forget_Password_Activity.class);
                startActivity(intent);
            }
        });

        hideIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideIV.setVisibility(View.GONE);
                showIV.setVisibility(View.VISIBLE);
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        showIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideIV.setVisibility(View.VISIBLE);
                showIV.setVisibility(View.GONE);
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
    }
}