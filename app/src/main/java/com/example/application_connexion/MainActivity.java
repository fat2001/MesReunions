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
    Button btn_login1;
    TextView getSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSignup = findViewById(R.id.Sign_up);
        et_username = findViewById(R.id.et_username2);
        et_password = findViewById(R.id.et_password2);
        btn_login1 = (Button) findViewById(R.id.btn_login);
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


        btn_login1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               if (et_username.getText().toString().equals("admin") && et_password.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this,adminacceuil.class);

                    startActivity(intent);
               } else {
                   Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}