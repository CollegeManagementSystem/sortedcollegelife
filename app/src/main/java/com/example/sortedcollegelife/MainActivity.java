package com.example.sortedcollegelife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    Button myloginstudent,myloginteacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myloginstudent=findViewById(R.id.studentLogin);
        myloginteacher=findViewById(R.id.teacherlogin);
        myloginstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirebaseAuth.getInstance().getCurrentUser()==null)
                {
                    Intent I1=new Intent(MainActivity.this,studentlogin.class);
                    startActivity(I1);

                }
                else{
                    Intent goToLogin =new Intent(MainActivity.this, studentmain.class);
                    startActivity(goToLogin);
                    finish();
                }
                // manager.sandActiveNow();

            }
        });
        myloginteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(MainActivity.this,teacherlogin.class);
                startActivity(I1);
            }
        });
    }
}
