package com.example.sortedcollegelife;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alarm extends AppCompatActivity {

    EditText mytext;
    Button myalarmset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        mytext=findViewById(R.id.alarmtext);
        myalarmset=findViewById(R.id.alarmsubmit);
        myalarmset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int d=Integer.parseInt(mytext.getText().toString());
                Intent intent = new Intent(alarm.this,AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(alarm.this,23424243, intent, 0);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ d*1000, pendingIntent);

                Toast.makeText(alarm.this, "Alarm set in " + d + " seconds", Toast.LENGTH_LONG).show();
            }
        });


    }
}
