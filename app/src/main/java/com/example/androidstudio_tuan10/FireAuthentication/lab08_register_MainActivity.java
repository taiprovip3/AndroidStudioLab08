package com.example.androidstudio_tuan10.FireAuthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseUser;

public class lab08_register_MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnRegister;
    private EditText edEmail;
    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab08_register__main);

        mAuth = FirebaseAuth.getInstance();

        btnRegister = (Button) findViewById(R.id.register_btnRegister);
        edEmail = (EditText) findViewById(R.id.register_edEmail);
        edPassword = (EditText) findViewById(R.id.register_edPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangKy();
            }
        });
    }//End onCreate

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    private void dangKy(){
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(lab08_register_MainActivity.this, "????ng k?? t??i kho???n th??nh c??ng", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(lab08_register_MainActivity.this, "????ng k?? th???t b???i.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}