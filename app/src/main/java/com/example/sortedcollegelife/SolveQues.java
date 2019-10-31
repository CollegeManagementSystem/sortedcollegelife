package com.example.sortedcollegelife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SolveQues extends AppCompatActivity {

    String doubt;
    TextView mydoubt;
    EditText myquessolution;
    Button mysubmit;
    DatabaseReference mdata;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_ques);
        doubt=getIntent().getExtras().get("Ques").toString();
        mydoubt=findViewById(R.id.doubtques);
        mdata=FirebaseDatabase.getInstance().getReference();
        mauth=FirebaseAuth.getInstance();
        myquessolution=findViewById(R.id.doubtsolution);
        mysubmit=findViewById(R.id.doubtsolutionsubmit);
        mydoubt.setText(doubt);
        mysubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=myquessolution.getText().toString();
                mdata.child("Questions").child(doubt).child(mauth.getUid()).push();
                mdata.child("Questions").child(doubt).child(mauth.getUid()).setValue(s1);
            }
        });
    }
}
