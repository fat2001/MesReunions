package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button btn_login;
    TextView getSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSignup = findViewById(R.id.Sign_up);
        //login();

        getSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }

        });
    }

   /* void login() {
        et_username = findViewById(R.id.et_username1);
        et_password = findViewById(R.id.et_password1);
        btn_login = findViewById(R.id.btn_login1);

        btn_login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (et_username.getText().toString().equals("admin") && et_password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Nom d'utilisateur et mot de passe corrects", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,com.example.application_connexion.Admin.class);

                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/
}