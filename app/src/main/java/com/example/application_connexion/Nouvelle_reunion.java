package com.example.application_connexion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import  static android.Manifest.permission.CAMERA;


import java.util.Calendar;

public class Nouvelle_reunion extends AppCompatActivity  implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener{
private EditText edittextDate,editTextTime;
private DatePickerDialog datePickerDialog;
private TimePickerDialog mTimePickerDialog;

 Button btnprendre;
   Uri imageAffiche;
 ImageView ivphoto;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_reunion);
        ivphoto=findViewById(R.id.ivphoto);

        //photo
       /* ivphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean pick=true;
                if(pick==true){
                    if (!checkCameraPermission()) {
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if (!checkStoragePermission()) {
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });*/

//camera
        btnprendre=findViewById(R.id.btnPrendre);
        ivphoto=findViewById(R.id.ivphoto);

        btnprendre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED)
                    {
                        String[]tabPermission={Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(tabPermission,100);
                    }
                    else
                        ChoisirPhotoGallerie();
                }
                else
                    ChoisirPhotoGallerie();
            }
        });



        // spinner
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner1=findViewById(R.id.servise);

// type
        String [] Types ={"choisir une type","interne","externe"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Types);
        spinner.setAdapter(arrayAdapter);
//service
        String [] Services ={"choisir une Division","DAI","DAS","DAEC","DUE","DAR","RNP","RSU","DE","DCL"};
        ArrayAdapter<String>arrayAdapter1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Services);
        spinner1.setAdapter(arrayAdapter1);



        //date
        edittextDate=findViewById(R.id.editTextDate);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog=new DatePickerDialog(this,this,year,month,day);
        datePickerDialog.setCancelable(true);
        edittextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }



    //camera
    private void ChoisirPhotoGallerie()
    {
        Intent imageIntent=new Intent(Intent.ACTION_PICK);
        imageIntent.setType("image/*");
        startActivityForResult(imageIntent,101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==100)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            ChoisirPhotoGallerie();
            else
                Toast.makeText(this,"Permission manquante",Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode==101 && resultCode==RESULT_OK)
           ivphoto.setImageURI(data.getData());
        super.onActivityResult(requestCode, resultCode, data);
    }
//date
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month +=1;
        String date= dayOfMonth + "/"+month+"/"+ year;
        edittextDate.setText(date);

        //time
        editTextTime=findViewById(R.id.editTextTime);
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        mTimePickerDialog=new TimePickerDialog(this,this,hour,minute,false);
        mTimePickerDialog.setCancelable(true);
        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimePickerDialog.show();
            }
        });


    }





    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time=hourOfDay + ":" +minute;
        editTextTime.setText(time);
    }
}