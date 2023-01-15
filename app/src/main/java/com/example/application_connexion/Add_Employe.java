package com.example.application_connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Employe extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nom,classe;
    Button add;
    Spinner spinner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employe);
            nom=findViewById(R.id.nom);
            classe=findViewById(R.id.classe);
            add=findViewById(R.id.Add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getApplicationContext(),Employe.class);
                    i.putExtra("nom",nom.getText().toString());
                    i.putExtra("classe",classe.getText().toString());
                    startActivity(i);

                }
            });
            spinner=findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
      spinner.setAdapter(adapter);
      spinner.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}