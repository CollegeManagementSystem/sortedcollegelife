package com.example.sortedcollegelife;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Currency;

import static com.example.sortedcollegelife.MainActivity.timetable_status;

public class timetable extends AppCompatActivity {

    EditText mytimetable[] = new EditText[10];
    SquiliteDatabase newsqlite;
    Button mysubmitdetails;
    private int notificationId=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        mysubmitdetails=findViewById(R.id.submittimetable);
        mysubmitdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squiliteTable();

/*
                Intent I2=new Intent(timetable.this,AlarmReceiver.class);
                I2.putExtra("notification",notificationId);
                PendingIntent alarmintent=PendingIntent.getBroadcast(timetable.this,
                        0,I2, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar starttime=Calendar.getInstance();
                starttime.set(Calendar.HOUR_OF_DAY,11);
                starttime.set(Calendar.MINUTE,12);
                starttime.set(Calendar.SECOND,0);
                long alarmstarttime=starttime.getTimeInMillis();


                alarm.set(AlarmManager.RTC_WAKEUP,alarmstarttime,alarmintent);
                Toast.makeText(timetable.this,"okay",Toast.LENGTH_LONG).show();*/


            }
        });




    }

    private void squiliteTable() {
        timetable_status=1;
        newsqlite=new SquiliteDatabase(this);


        mytimetable[0]=findViewById(R.id.timetablemon830);
        mytimetable[1]=findViewById(R.id.timetablemon925);
        mytimetable[2]=findViewById(R.id.timetablemon1020);
        mytimetable[3]=findViewById(R.id.timetablemon1125);
        mytimetable[4]=findViewById(R.id.timetablemon1230);
        mytimetable[5]=findViewById(R.id.timetablemon145);
        mytimetable[6]=findViewById(R.id.timetablemon240);
        mytimetable[7]=findViewById(R.id.timetablemon325);
        newsqlite.adddetails("Monday",mytimetable[0].getText().toString(),mytimetable[1].
                        getText().toString(),mytimetable[2].getText().toString(),mytimetable[3].getText()
                        .toString(),mytimetable[4].getText().toString(),mytimetable[5].getText().toString()
                ,mytimetable[6].getText().toString(),mytimetable[7].getText().toString());




        mytimetable[0]=findViewById(R.id.timetabletues830);
        mytimetable[1]=findViewById(R.id.timetabletues925);
        mytimetable[2]=findViewById(R.id.timetabletues1020);
        mytimetable[3]=findViewById(R.id.timetabletues1125);
        mytimetable[4]=findViewById(R.id.timetabletues1230);
        mytimetable[5]=findViewById(R.id.timetabletues145);
        mytimetable[6]=findViewById(R.id.timetabletues240);
        mytimetable[7]=findViewById(R.id.timetabletues325);
        newsqlite.adddetails("Monday",mytimetable[0].getText().toString(),mytimetable[1].
                        getText().toString(),mytimetable[2].getText().toString(),mytimetable[3].getText()
                        .toString(),mytimetable[4].getText().toString(),mytimetable[5].getText().toString()
                ,mytimetable[6].getText().toString(),mytimetable[7].getText().toString());



        mytimetable[0]=findViewById(R.id.timetablewed830);
        mytimetable[1]=findViewById(R.id.timetablewed925);
        mytimetable[2]=findViewById(R.id.timetablewed1020);
        mytimetable[3]=findViewById(R.id.timetablewed1125);
        mytimetable[4]=findViewById(R.id.timetablewed1230);
        mytimetable[5]=findViewById(R.id.timetablewed145);
        mytimetable[6]=findViewById(R.id.timetablewed240);
        mytimetable[7]=findViewById(R.id.timetablewed325);
        newsqlite.adddetails("Monday",mytimetable[0].getText().toString(),mytimetable[1].
                        getText().toString(),mytimetable[2].getText().toString(),mytimetable[3].getText()
                        .toString(),mytimetable[4].getText().toString(),mytimetable[5].getText().toString()
                ,mytimetable[6].getText().toString(),mytimetable[7].getText().toString());


        mytimetable[0]=findViewById(R.id.timetablethu830);
        mytimetable[1]=findViewById(R.id.timetablethu925);
        mytimetable[2]=findViewById(R.id.timetablethu1020);
        mytimetable[3]=findViewById(R.id.timetablethu1125);
        mytimetable[4]=findViewById(R.id.timetablethu1230);
        mytimetable[5]=findViewById(R.id.timetablethu145);
        mytimetable[6]=findViewById(R.id.timetablethu240);
        mytimetable[7]=findViewById(R.id.timetablethu325);
        newsqlite.adddetails("Monday",mytimetable[0].getText().toString(),mytimetable[1].
                        getText().toString(),mytimetable[2].getText().toString(),mytimetable[3].getText()
                        .toString(),mytimetable[4].getText().toString(),mytimetable[5].getText().toString()
                ,mytimetable[6].getText().toString(),mytimetable[7].getText().toString());





        mytimetable[0]=findViewById(R.id.timetablefri830);
        mytimetable[1]=findViewById(R.id.timetablefri925);
        mytimetable[2]=findViewById(R.id.timetablefri1020);
        mytimetable[3]=findViewById(R.id.timetablefri1125);
        mytimetable[4]=findViewById(R.id.timetablefri1230);
        mytimetable[5]=findViewById(R.id.timetablefri145);
        mytimetable[6]=findViewById(R.id.timetablefri240);
        mytimetable[7]=findViewById(R.id.timetablefri325);
        newsqlite.adddetails("Monday",mytimetable[0].getText().toString(),mytimetable[1].
                        getText().toString(),mytimetable[2].getText().toString(),mytimetable[3].getText()
                        .toString(),mytimetable[4].getText().toString(),mytimetable[5].getText().toString()
                ,mytimetable[6].getText().toString(),mytimetable[7].getText().toString());


        Cursor c1=newsqlite.fetch("1","1");
        String s2="";
        while (c1.moveToNext()){
            String s1=c1.getString(1);
            s2=s2+s1;

        }
        Toast.makeText(this, s2, Toast.LENGTH_SHORT).show();
        String k="kk";
        int a1;



    }
}

