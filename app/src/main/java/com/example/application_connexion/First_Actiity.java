package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class First_Actiity extends AppCompatActivity {
Button btn_Admin,btn_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_actiity);
        btn_Admin=findViewById(R.id.btn_admin);
        btn_User=findViewById(R.id.btn_user);


        btn_Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(First_Actiity.this,MainActivity.class);
                startActivity(intent);
            }

        });
        btn_User.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(First_Actiity.this,Employe_login.class);
                startActivity(intent);
            }

        });

    }

}