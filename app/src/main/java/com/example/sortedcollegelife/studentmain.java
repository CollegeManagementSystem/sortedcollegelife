package com.example.sortedcollegelife;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.RequiresApi;

import static com.example.sortedcollegelife.MainActivity.checkauth;
import static com.example.sortedcollegelife.MainActivity.timetable_status;

public class studentmain extends AppCompatActivity {

    ImageButton mytimetable, mytimetanble1;
    Bitmap imageBitmap;
    EditText mytimetabletext;
    Button mchat,mtimetable,myalarmset,mydoubt;
    DatabaseReference mdata,mdata1;
    String s1,phoneNumber,studentname,studentroll,studentclass;
    ArrayList<String> contacts;
    FirebaseAuth mAuth;
    static String phone_nuumber;
    SquiliteDatabase newsql;
    int f=0;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static int RESULT_LOAD_IMAGE = 1;
    private int notificationId=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentmain);
        myalarmset=findViewById(R.id.setalarm);
        myalarmset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(studentmain.this,alarm.class);
                startActivity(I1);
            }
        });
        mydoubt=findViewById(R.id.doubt1);
        mydoubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(studentmain.this,Quora.class);
                int a1;
                startActivity(I1);
            }
        });
        mchat=findViewById(R.id.chat);
        mchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(checkauth==1){
                    mdata= FirebaseDatabase.getInstance().getReference();
                    mAuth=FirebaseAuth.getInstance();
                    phoneNumber=getIntent().getExtras().getString("studentphone");
                    phone_nuumber=phoneNumber;
                    studentname=getIntent().getExtras().getString("studentname");

                    studentroll=getIntent().getExtras().getString("studentroll");

                    studentclass=getIntent().getExtras().getString("studentclass");

                    mdata.child("contactlist").child(mAuth.getUid()).push();
                    mdata.child("contactlist").child(mAuth.getUid()).setValue(phoneNumber);


                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("contact").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("contact").setValue(phoneNumber);

                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_Name").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_Name").setValue(studentname);

                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Roll_Number").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Roll_Number").setValue(studentroll);

                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_class").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_class").setValue(studentclass);


                    mdata.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            DataSnapshot post=dataSnapshot.child("contactlist");
                            for(DataSnapshot p:post.getChildren()){
                                if(f==0){
                                    mdata.child("Student").child("chat").child(phoneNumber).child(p.getValue().toString()).push();
                                    mdata.child("Student").child("chat").child(phoneNumber).child(p.getValue().toString()).setValue("");
                                }

                            }
                            int a1=0;
                            for(DataSnapshot p:post.getChildren()){
                                a1++;
                            }
                            System.out.print(a1);
                            f=1;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else{
                    mdata= FirebaseDatabase.getInstance().getReference();
                    mAuth=FirebaseAuth.getInstance();
                    mdata1=mdata.child("contactlist").child(mAuth.getUid());
                    mdata1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            phone_nuumber=dataSnapshot.getValue().toString();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


                Intent I1=new Intent(studentmain.this,ChatList.class);
                startActivity(I1);
            }
        });
        mtimetable=findViewById(R.id.timetable1);
        mtimetable.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                if(checkauth==1){
                    mdata= FirebaseDatabase.getInstance().getReference();
                    mAuth=FirebaseAuth.getInstance();
                    phoneNumber=getIntent().getExtras().getString("studentphone");
                    phone_nuumber=phoneNumber;
                    studentname=getIntent().getExtras().getString("studentname");

                    studentroll=getIntent().getExtras().getString("studentroll");

                    studentclass=getIntent().getExtras().getString("studentclass");

                    mdata.child("contactlist").child(mAuth.getUid()).push();
                    mdata.child("contactlist").child(mAuth.getUid()).setValue(phoneNumber);


                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("contact").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("contact").setValue(phoneNumber);

                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_Name").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_Name").setValue(studentname);

                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Roll_Number").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Roll_Number").setValue(studentroll);

                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_class").push();
                    mdata.child("Student").child("Details").child(mAuth.getUid()).child("Student_class").setValue(studentclass);


                    mdata.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            DataSnapshot post=dataSnapshot.child("contactlist");
                            for(DataSnapshot p:post.getChildren()){
                                if(f==0){
                                    mdata.child("Student").child("chat").child(phoneNumber).child(p.getValue().toString()).push();
                                    mdata.child("Student").child("chat").child(phoneNumber).child(p.getValue().toString()).setValue("");
                                }

                            }
                            int a1=0;
                            for(DataSnapshot p:post.getChildren()){
                                a1++;
                            }
                            System.out.print(a1);
                            f=1;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else{
                    mdata= FirebaseDatabase.getInstance().getReference();
                    mAuth=FirebaseAuth.getInstance();
                    mdata1=mdata.child("contactlist").child(mAuth.getUid());
                    mdata1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            phone_nuumber=dataSnapshot.getValue().toString();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


                /*if(timetable_status==1){

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String s1=now.toString();

                    char hours1=s1.charAt(s1.length()-8);
                    char hours2=s1.charAt(s1.length()-7);
                    String k="";
                    k=k+hours1+hours2;
                    int hour=Integer.parseInt(k);


                    char min1=s1.charAt(s1.length()-5);
                    char min2=s1.charAt(s1.length()-4);
                    String k1="";
                    k1=k1+min1+min2;
                    int min=Integer.parseInt(k);


                    Calendar calender=Calendar.getInstance();
                    int day=calender.get(Calendar.DAY_OF_WEEK);


                    newsql=new SquiliteDatabase(studentmain.this);
                    Cursor c1=newsql.fetch("1","1");

                    int temp=0;
                    switch (day){
                        case Calendar.MONDAY:
                            temp=0;
                            while (c1.moveToNext()){
                                temp++;
                                if(temp==1)
                                    break;
                            }

                            if((hour==8&&min==20&&c1.getString(1).length()>0)||
                                    (hour==9&&min==15&&c1.getString(2).length()>0)||
                                    (hour==10&&min==10&&c1.getString(3).length()>0)||
                                    (hour==11&&min==15&&c1.getString(4).length()>0)||
                                    (hour==12&&min==20&&c1.getString(5).length()>0)||
                                    (hour==1&&min==15&&c1.getString(6).length()>0)||
                                    (hour==2&&min==30&&c1.getString(7).length()>0)||
                                    (hour==3&&min==15&&c1.getString(8).length()>0))
                            {



                            }
                        case Calendar.TUESDAY:
                            temp=0;
                            while (c1.moveToNext()){
                                temp++;
                                if(temp==2)
                                    break;
                            }
                        case  Calendar.WEDNESDAY:
                            temp=0;
                            while (c1.moveToNext()){
                                temp++;
                                if(temp==3)
                                    break;
                            }
                        case Calendar.THURSDAY:
                            temp=0;
                            while (c1.moveToNext()){
                                temp++;
                                if(temp==4)
                                    break;
                            }
                        case Calendar.FRIDAY:
                            temp=0;
                            while (c1.moveToNext()){
                                temp++;
                                if(temp==5)
                                    break;
                            }

                    }

                    while (c1.moveToNext()){
                        for(int j=1;j<=8;j++){
                            if(c1.getString(j).length()>0){

                            }
                        }
                    }
                }*/
                Intent I1=new Intent(studentmain.this,timetable_main.class);
                startActivity(I1);
            }
        });
        /*mytimetable = findViewById(R.id.timetable);
        mytimetanble1 = findViewById(R.id.timetable1);
        mytimetabletext = findViewById(R.id.timetabletext);
        mytimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageCapture();

            }
        });
        mytimetanble1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store_timetable();
            }
        });*/
    }

    private void store_timetable() {

        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(imageBitmap);
        FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance().
                getOnDeviceTextRecognizer();
        detector.processImage(image).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
            @Override
            public void onSuccess(FirebaseVisionText firebaseVisionText) {
                processtextrecog(firebaseVisionText);
            }


        });

    }

    private void processtextrecog(FirebaseVisionText firebaseVisionText) {
        List<FirebaseVisionText.TextBlock> blocks1 = firebaseVisionText.getTextBlocks();
        //List<FirebaseVisionText.TextBlock>blocks =firebaseVisionText.getTextBlocks();
        if (blocks1.size() == 0)
            Toast.makeText(studentmain.this, "no", Toast.LENGTH_LONG).show();
        else {
            String txt = "";
            for (FirebaseVisionText.TextBlock blo : firebaseVisionText.getTextBlocks()) {
                txt = txt + blo.getText() + "    ";
            }
            /*String s1="";
            for(int i=0;i<blocks1.size();i++){

                List<FirebaseVisionText.Line>lines=blocks1.get(i).getLines();
                for(int j=0;j<lines.size();j++){
                    List<FirebaseVisionText.Element>elements=lines.get(i).getElements();
                    s1=s1+elements.toString();
                }
            }*/
            mytimetabletext.setText(txt);

        }
    }

    private void ImageCapture() {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);

       /* Intent I1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (I1.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(I1, REQUEST_IMAGE_CAPTURE);
        }*/
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            imageBitmap = drawable.getBitmap();
            // String picturePath contains the path of selected Image
        }
    }*/
}
