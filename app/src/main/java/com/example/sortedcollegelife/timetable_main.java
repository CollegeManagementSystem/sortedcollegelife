package com.example.sortedcollegelife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class timetable_main extends AppCompatActivity {

    Button myupdatedetails,myviewdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_main);
        myupdatedetails=findViewById(R.id.updatetime);
        myviewdetails=findViewById(R.id.viewtimetable);

        myupdatedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(timetable_main.this,timetable.class);
                startActivity(I1);
            }
        });
        myviewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(timetable_main.this,showTimeTable.class);
                startActivity(I1);
            }
        });
    }
}
