package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class Detail_Employe extends AppCompatActivity {
EditText nom,classe;
Button mod,sup;
int position;
Params p=new Params();
    HashMap<String,String> m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_employe);
    nom=findViewById(R.id.nom);
    classe=findViewById(R.id.classe);
    mod=findViewById(R.id.modifier);
    sup=findViewById(R.id.supprimer);

    Bundle extras=getIntent().getExtras();
    if(extras!=null){
        position=extras.getInt("position");
    }

     m = p.values.get(position);
nom.setText(m.get("nom"));
classe.setText(m.get("classe"));

mod.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        m.put("nom",nom.getText().toString());
        m.put("classe",classe.getText().toString());
        Intent i=new Intent(getApplicationContext(),Employe.class);
        startActivity(i);
        finish();

    }});
sup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        p.values.remove(position);
        Intent i=new Intent(getApplicationContext(),Employe.class);
        startActivity(i);
        finish();
    }
});



    }
}