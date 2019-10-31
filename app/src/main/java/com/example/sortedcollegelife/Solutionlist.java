package com.example.sortedcollegelife;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Solutionlist extends AppCompatActivity {


    DatabaseReference mdata;
    RecyclerView mrecycle;
    SolutionAdapter madapter;
    String quesname;
    TextView mtext;
    ArrayList<String> mysolutionlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutionlist);
        mdata= FirebaseDatabase.getInstance().getReference();
        mrecycle=(RecyclerView)findViewById(R.id.solutionlistrecycle);
        mrecycle.setLayoutManager(new LinearLayoutManager(this));
        quesname=getIntent().getExtras().get("Ques").toString();
        mtext=findViewById(R.id.solutionname);
        mtext.setText(quesname);
        mysolutionlist=new ArrayList<>();
        mdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot post=dataSnapshot.child("Questions").child(quesname);
                for(DataSnapshot p: post.getChildren()){
                    mysolutionlist.add(p.getValue().toString());
                }
                madapter=new SolutionAdapter(Solutionlist.this,mysolutionlist);
                mrecycle.setAdapter(madapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
