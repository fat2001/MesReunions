package com.example.application_connexion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class adminacceuil extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5,textView6;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_acceuil);
       /* textView1 =(TextView) findViewById(R.id.t1);
        textView2 =(TextView) findViewById(R.id.t2);
        textView3 =(TextView) findViewById(R.id.t3);
        textView4 =(TextView) findViewById(R.id.t4);
        textView5=(TextView) findViewById(R.id.t5);
        textView6=(TextView) findViewById(R.id.t6);
        Intent receivedintent=getIntent();
        String receivedvalue= receivedintent.getStringExtra("KEY_SENDER");
        String receivedvalue1= receivedintent.getStringExtra("date");
        String receivedvalue2= receivedintent.getStringExtra("time");
        String receivedvalue3= receivedintent.getStringExtra("lieu");
        String receivedvalue4= receivedintent.getStringExtra("type");
        String receivedvalue5= receivedintent.getStringExtra("servise");
        textView1.setText(receivedvalue);
        textView2.setText(receivedvalue1);
        textView3.setText(receivedvalue2);
        textView4.setText(receivedvalue3);
        textView6.setText(receivedvalue4);
        textView6.setText(receivedvalue5);
        Toast.makeText(adminacceuil.this, "Nouvelle activité", Toast.LENGTH_SHORT).show();*/

    }


}
