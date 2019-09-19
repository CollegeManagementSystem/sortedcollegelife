package com.example.sortedcollegelife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class studentlogin extends AppCompatActivity {

    EditText mystudentname,mystudentroll,mystudentphone,mystudentclass;
    Button mystudentsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);
        /*if(FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            Intent goToLogin =new Intent(studentlogin.this, studentmain.class);
            startActivity(goToLogin);
            finish();

        }
        else;
        // manager.sandActiveNow();
*/
        mystudentname=findViewById(R.id.studentname);
        mystudentroll=findViewById(R.id.studentroll);
        mystudentphone=findViewById(R.id.studentphone);
        mystudentsubmit=findViewById(R.id.studentsubmit);
        mystudentclass=findViewById(R.id.studentclass);
        mystudentsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(studentlogin.this,otpverify.class);
                I1.putExtra("studentphone",mystudentphone.getText().toString());
                I1.putExtra("studentname",mystudentname.getText().toString());
                I1.putExtra("studentroll",mystudentroll.getText().toString());
                I1.putExtra("studentclass",mystudentclass.getText().toString());
                startActivity(I1);
            }
        });
    }
}
