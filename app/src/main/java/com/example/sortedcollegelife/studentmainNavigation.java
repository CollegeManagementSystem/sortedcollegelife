
package com.example.sortedcollegelife;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.sortedcollegelife.MainActivity.checkauth;

public class studentmainNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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
        setContentView(R.layout.activity_studentmain_navigation);
        ImageButton Img1=findViewById(R.id.link1);
        Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com"));
                startActivity(I1);
            }
        });
        ImageButton Img2=findViewById(R.id.link2);
        Img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(I1);
            }
        });
        ImageButton Img3=findViewById(R.id.link3);
        Img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com"));
                startActivity(I1);
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_doubt) {
            Intent I1=new Intent(studentmainNavigation.this,Quora.class);
            int a1;
            startActivity(I1);
            // Handle the camera action
        } else if (id == R.id.nav_timetable) {



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


            Intent I1=new Intent(studentmainNavigation.this,showTimeTable.class);
            startActivity(I1);


        } else if (id == R.id.nav_alarm) {
            Intent I1=new Intent(studentmainNavigation.this,alarm.class);
            startActivity(I1);

        } else if (id == R.id.nav_share) {
            Intent I1=new Intent(studentmainNavigation.this,Location.class);
            startActivity(I1);

        }
        else if(id==R.id.nav_chat){

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

            Intent I1=new Intent(studentmainNavigation.this,studentmain.class);
            startActivity(I1);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
