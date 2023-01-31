package com.example.application_connexion;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Novell_reunion extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
private EditText edittextDate,editTextTime;
private DatePickerDialog datePickerDialog;
    private TimePickerDialog mTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_reunion);
        //date
        edittextDate=findViewById(R.id.editTextDate);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog=new DatePickerDialog(this,this,year,month,day);
        datePickerDialog.setCancelable(true);
        edittextDate.setOnClickListener(v -> datePickerDialog.show());
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month +=1;
        String date= dayOfMonth + "/"+month+"/"+ year;
        edittextDate.setText(date);

        //time
        editTextTime=findViewById(R.id.editTextTime);
        Calendar cal=Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        mTimePickerDialog=new TimePickerDialog(this,this,hour,minute,false);
        editTextTime.setOnClickListener(v -> mTimePickerDialog.show());


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time=hourOfDay + ":" +minute;
        editTextTime.setText(time);
    }
}