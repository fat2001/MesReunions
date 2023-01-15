package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Admin extends AppCompatActivity {
LinearLayout id_employe;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        id_employe=findViewById(R.id.id_employe);
         id_employe.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(Admin.this,Add_Employe.class);
                 startActivity(i);
             }
         });

    }

}