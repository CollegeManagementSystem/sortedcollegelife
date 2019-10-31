package com.example.sortedcollegelife;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatList extends AppCompatActivity {

    DatabaseReference mdata;
    String s1;
    ArrayList<String>contacts;
    ContactAdapter myadapter;
    RecyclerView callreccle;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        callreccle=(RecyclerView)findViewById(R.id.recyclerchat);
        callreccle.setLayoutManager(new LinearLayoutManager(this));
        contacts=new ArrayList<>();
        mdata= FirebaseDatabase.getInstance().getReference();
        mdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot post=dataSnapshot.child("contactlist");
                for (DataSnapshot p:post.getChildren()){
                   if(f==0){
                       contacts.add(p.getValue().toString());
                   }
                }
                f=1;
                myadapter=new ContactAdapter(ChatList.this,contacts);
                callreccle.setAdapter(myadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
