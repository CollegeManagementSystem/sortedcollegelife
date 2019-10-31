package com.example.sortedcollegelife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuesAsk extends AppCompatActivity {

    Button mysubmittext;
    EditText mytext;
    DatabaseReference mdata;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_ask);
        mysubmittext=findViewById(R.id.quesasksubmit);
        mdata= FirebaseDatabase.getInstance().getReference();
        mauth=FirebaseAuth.getInstance();
        mytext=findViewById(R.id.questext);
        mysubmittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=mytext.getText().toString();
                mdata.child("Questions").child(s1).child(mauth.getUid()).push();
                mdata.child("Questions").child(s1).child(mauth.getUid()).setValue("");
            }
        });
    }
}
