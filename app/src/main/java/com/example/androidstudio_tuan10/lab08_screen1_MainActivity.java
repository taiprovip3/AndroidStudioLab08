package com.example.androidstudio_tuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lab08_screen1_MainActivity extends AppCompatActivity {
    Button btnSignin;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab08_screen1__main);


        btnSignin = (Button) findViewById(R.id.screen1_btnSignin);
        btnRegister = (Button) findViewById(R.id.screen1_btnRegister);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, MainActivity.class);
                Intent intent = new Intent(lab08_screen1_MainActivity.this, lab08_signin_MainActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lab08_screen1_MainActivity.this, lab08_register_MainActivity.class);
                startActivity(intent);
            }
        });
    }//end onCreate
}