package com.example.sortedcollegelife;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.sortedcollegelife.studentmain.phone_nuumber;

public class MainChat extends AppCompatActivity {

    DatabaseReference mdata,mdata1;
    FirebaseAuth mauth;
    mainchatadapter madapter;
    RecyclerView mrecycle;
    String a1="",s1="",temp1="",temp2="";
    Button msend;
    EditText mtext;
    TextView mchatname;
    LiveChatData newSendData;

    ArrayList<LiveChatData> mData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        mdata=FirebaseDatabase.getInstance().getReference();
        mauth=FirebaseAuth.getInstance();
        mchatname=findViewById(R.id.mainchatname);

        mrecycle=(RecyclerView)findViewById(R.id.mainchatrecycle);

        madapter=new mainchatadapter(this,mData);
        mrecycle.setAdapter(madapter);
        mrecycle.setLayoutManager(new LinearLayoutManager(this));

        temp2=getIntent().getExtras().getString("chatphonenumber");
        mchatname.setText(temp2);

        String s3=mauth.getUid().toString();
        temp1=phone_nuumber;
        int a2;
        mdata.child("Student").child("chat").
                child(temp1).child(temp2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a1=dataSnapshot.getValue().toString();
                if(a1.length()>0){
                    newSendData=new LiveChatData();
                    newSendData.setData(a1);
                    newSendData.setSedRec(0);

                    mData.add(newSendData);

                    madapter.notifyItemChanged(mData.size());

                    mdata.child("Student").child("chat").
                            child(temp1).child(temp2).setValue("");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

       msend=findViewById(R.id.mainchatsendbutton);
       mtext=findViewById(R.id.mainchatsendtext);
       msend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainChat.this,"hello",Toast.LENGTH_LONG).show();
               mdata.child("Student").child("chat").
                       child(temp1).child(temp2).addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       a1=dataSnapshot.getValue().toString();
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
               if(a1.length()>0){
                   newSendData=new LiveChatData();
                   newSendData.setData(a1);
                   newSendData.setSedRec(0);

                   mData.add(newSendData);

                   madapter.notifyItemChanged(mData.size());

                   mdata.child("Student").child("chat").
                           child(temp1).child(temp2).setValue("");

               }
               s1=mtext.getText().toString();
               if(s1!=""){
                   newSendData=new LiveChatData();
                   newSendData.setData(s1);
                   newSendData.setSedRec(1);
                   mData.add(newSendData);
                   //madapter.notifyItemChanged(mData.size());
                   //madapter.notifyItemInserted(mData.size()+1);
                   mdata.child("Student").child("chat").child(temp2).child(temp1).setValue(s1);

                   mtext.setText("");
               }

           }

       });

    }

}
