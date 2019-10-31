package com.example.sortedcollegelife;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class doubtsession extends AppCompatActivity {

/*    String s1;
    ArrayList<String> mydoubt;
    Button myaskdoubt;
    DatabaseReference mdata;
    FirebaseAuth mauth;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubtsession);
    }
}   /*int a = 1;
        mauth=FirebaseAuth.getInstance();
        mdata= FirebaseDatabase.getInstance().getReference();
        myaskdoubt=findViewById(R.id.quesask);
        myaskdoubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(doubtsession.this,QuesAsk.class);
                startActivity(I1);

            }
        });
        mydoubt=new ArrayList<>();
        DatabaseReference mDatabase;

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot post=dataSnapshot.child("Questions");
                for(DataSnapshot p:post.getChildren()){
                        mydoubt.add(p.getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        RecyclerView callreccle=(RecyclerView)findViewById(R.id.ques);
        callreccle.setLayoutManager(new LinearLayoutManager(this));
        callreccle.setAdapter(new Ques_Adapter(this, mydoubt));
    }
}*/
