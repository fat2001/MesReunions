package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Employe_login extends AppCompatActivity {
    EditText et_username1, et_password1;
    Button btn_login1;
    TextView forget,signup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_login);
        forget=findViewById(R.id.forget);
        signup=findViewById(R.id.Sign_up    );
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singupIntent=new Intent(Employe_login.this,com.example.application_connexion.Register.class);
            }
        });




        login();
    }
    void login() {
        et_username1 = findViewById(R.id.et_username1);
        et_password1 = findViewById(R.id.et_password1);
        btn_login1 = findViewById(R.id.btn_login1);

        btn_login1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (et_username1.getText().toString().equals("user") && et_password1.getText().toString().equals("user")) {
                    Toast.makeText(Employe_login.this, "Nom d'utilisateur et mot de passe corrects", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Employe_login.this,com.example.application_connexion.MenuActivity.class);

                    startActivity(intent);
                } else {
                    Toast.makeText(Employe_login.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}