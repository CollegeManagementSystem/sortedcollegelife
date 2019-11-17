package com.example.sortedcollegelife;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Location extends AppCompatActivity {

    Button msenate,mjubliee,msports,madmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        msenate=findViewById(R.id.senate);
        msenate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:29.94747905,76.818237"));
                startActivity(I1);
            }
        });
        mjubliee=findViewById(R.id.jubliee);
        mjubliee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:29.946517,76.815407"));
                startActivity(I1);
            }
        });
        msports=findViewById(R.id.sports);
        msports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:29.950532,76.815692"));
                startActivity(I1);
            }
        });
        madmin=findViewById(R.id.administration);
        madmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:29.948875,76.817233"));
                startActivity(I1);
            }
        });
    }
}
