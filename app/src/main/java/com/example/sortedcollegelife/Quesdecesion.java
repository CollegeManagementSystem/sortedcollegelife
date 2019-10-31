package com.example.sortedcollegelife;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Quesdecesion extends AppCompatActivity {


    TextView myquesname;
    Button myanswer,myanswerlist;
    String quesname;
    ArrayList<String>mysolutionlist;
    DatabaseReference mdata;
    RecyclerView mrecycle;
    SolutionAdapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesdecesion);
        myquesname=findViewById(R.id.quesname);
        quesname=getIntent().getExtras().get("Ques").toString();
        myanswer=findViewById(R.id.submitsolution);
        mysolutionlist=new ArrayList<>();
        myanswerlist=findViewById(R.id.solutions);
        myanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Quesdecesion.this,SolveQues.class);
                I1.putExtra("Ques",quesname);
                startActivity(I1);
            }
        });
        myanswerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Quesdecesion.this,Solutionlist.class);
                I1.putExtra("Ques",quesname);
                startActivity(I1);

            }
        });
    }
}
