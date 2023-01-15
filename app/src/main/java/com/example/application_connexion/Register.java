package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Register extends AppCompatActivity {
TextView getLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    getLogin=findViewById(R.id.Sign_in);

        getLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }

    });
}
}
