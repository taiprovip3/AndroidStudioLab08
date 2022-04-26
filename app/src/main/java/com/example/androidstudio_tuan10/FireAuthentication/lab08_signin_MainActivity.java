package com.example.androidstudio_tuan10.FireAuthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidstudio_tuan10.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class lab08_signin_MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText edEmail;
    EditText edPassword;
    Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab08_signin__main);

        mAuth = FirebaseAuth.getInstance();

        edEmail = (EditText) findViewById(R.id.signin_edEmail);
        edPassword = (EditText) findViewById(R.id.signin_edPassword);
        btnSignin = (Button) findViewById(R.id.signin_btnSignin);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangNhap();
            }
        });
    }
    private void dangNhap(){
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(lab08_signin_MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(lab08_signin_MainActivity.this, lab08_facescreen_MainActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(lab08_signin_MainActivity.this, "Đăng nhập thất bại thảm hại.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}