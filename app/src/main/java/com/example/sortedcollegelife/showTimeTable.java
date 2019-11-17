package com.example.sortedcollegelife;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showTimeTable extends AppCompatActivity {

    SquiliteDatabase mdata;
    TextView mtext[]=new TextView[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time_table);
        mdata=new SquiliteDatabase(this);
        Cursor c1=mdata.fetch("1","1");
        int i=0;
        Button update=findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(showTimeTable.this,timetable.class);
                startActivity(I1);
            }
        });
        while (c1.moveToNext()){
            if(i==0){

                mtext[0]=findViewById(R.id.stimetablemon830);
                mtext[1]=findViewById(R.id.stimetablemon925);
                mtext[2]=findViewById(R.id.stimetablemon1020);
                mtext[3]=findViewById(R.id.stimetablemon1125);
                mtext[4]=findViewById(R.id.stimetablemon1230);
                mtext[5]=findViewById(R.id.stimetablemon145);
                mtext[6]=findViewById(R.id.stimetablemon240);
                mtext[7]=findViewById(R.id.stimetablemon325);


                for(int j=1;j<=8;j++){
                    mtext[j-1].setText(c1.getString(j));
                }
            }
            else if(i==1){

                mtext[0]=findViewById(R.id.stimetabletues830);
                mtext[1]=findViewById(R.id.stimetabletues925);
                mtext[2]=findViewById(R.id.stimetabletues1020);
                mtext[3]=findViewById(R.id.stimetabletues1125);
                mtext[4]=findViewById(R.id.stimetabletues1230);
                mtext[5]=findViewById(R.id.stimetabletues145);
                mtext[6]=findViewById(R.id.stimetabletues240);
                mtext[7]=findViewById(R.id.stimetabletues325);


                for(int j=1;j<=8;j++){
                    mtext[j-1].setText(c1.getString(j));
                }
            }
            else if(i==2){

                mtext[0]=findViewById(R.id.stimetablewed830);
                mtext[1]=findViewById(R.id.stimetablewed925);
                mtext[2]=findViewById(R.id.stimetablewed1020);
                mtext[3]=findViewById(R.id.stimetablewed1125);
                mtext[4]=findViewById(R.id.stimetablewed1230);
                mtext[5]=findViewById(R.id.stimetablewed145);
                mtext[6]=findViewById(R.id.stimetablewed240);
                mtext[7]=findViewById(R.id.stimetablewed325);


                for(int j=1;j<=8;j++){
                    mtext[j-1].setText(c1.getString(j));
                }
            }
            else if(i==3){

                mtext[0]=findViewById(R.id.stimetablethu830);
                mtext[1]=findViewById(R.id.stimetablethu925);
                mtext[2]=findViewById(R.id.stimetablethu1020);
                mtext[3]=findViewById(R.id.stimetablethu1125);
                mtext[4]=findViewById(R.id.stimetablethu1230);
                mtext[5]=findViewById(R.id.stimetablethu145);
                mtext[6]=findViewById(R.id.stimetablethu240);
                mtext[7]=findViewById(R.id.stimetablethu325);


                for(int j=1;j<=8;j++){
                    mtext[j-1].setText(c1.getString(j));
                }
            }
            else if(i==4){

                mtext[0]=findViewById(R.id.stimetablefri830);
                mtext[1]=findViewById(R.id.stimetablefri925);
                mtext[2]=findViewById(R.id.stimetablefri1020);
                mtext[3]=findViewById(R.id.stimetablefri1125);
                mtext[4]=findViewById(R.id.stimetablefri1230);
                mtext[5]=findViewById(R.id.stimetablefri145);
                mtext[6]=findViewById(R.id.stimetablefri240);
                mtext[7]=findViewById(R.id.stimetablefri325);


                for(int j=1;j<=8;j++){
                    mtext[j-1].setText(c1.getString(j));
                }

            }
            i=i+1;
        }
    }
}
