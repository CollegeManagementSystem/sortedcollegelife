package com.example.sortedcollegelife;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

import static com.example.sortedcollegelife.MainActivity.checkauth;
import static com.example.sortedcollegelife.MainActivity.timetable_status;

public class otpverify extends AppCompatActivity {

    Button myotpback,myotpconform;
    EditText myotpedit;
    FirebaseAuth mAuth;
    TextView mResendB;
    TextView mOtpTimer;
    private String mVerificationId,code;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    DatabaseReference mdata;
    int otpFlag =0,f=0;
    private EditText codeText;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String phoneNumber,studentname,studentroll,studentclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);
        UI_initialisation();
        checkauth=1;

        authinitialisation();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

        myotpback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(otpverify.this,studentlogin.class);
                startActivity(I1);
            }
        });
        myotpconform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code= myotpedit.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
                signInWithPhoneAuthCredential(credential);
            }
        });
    }

    private void UI_initialisation() {
        myotpback=findViewById(R.id.otpBack);
        myotpconform=findViewById(R.id.otpConform);
        myotpedit=findViewById(R.id.otpEdit);
        mOtpTimer=findViewById(R.id.otpTimer);
        mResendB=findViewById(R.id.otpResend);
    }

    private void authinitialisation() {
        phoneNumber=getIntent().getExtras().getString("studentphone");
        studentname=getIntent().getExtras().getString("studentname");
        studentroll=getIntent().getExtras().getString("studentroll");
        studentclass=getIntent().getExtras().getString("studentclass");
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                signInWithPhoneAuthCredential(phoneAuthCredential);
                Intent I1=new Intent(otpverify.this, studentmain.class);
                I1.putExtra("studentname",studentname);
                I1.putExtra("studentroll",studentroll);
                I1.putExtra("studentclass",studentclass);
                I1.putExtra("studentphone",phoneNumber);
                f=1;
                startActivity(I1);
               Toast.makeText(otpverify.this,"welcome",Toast.LENGTH_LONG).show();
               finish();
            }
            @Override
            public void onVerificationFailed(FirebaseException e) {

                  Toast.makeText(otpverify.this,"error in verification",Toast.LENGTH_LONG).show();

            }
            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                mVerificationId = verificationId;
                mResendToken = token;
            }

        };
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth=FirebaseAuth.getInstance();
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Intent loggedIn = new Intent(otpverify.this, studentmain.class);
                            //loggedIn.putExtra(Bitmap.Config.PHONE_NUMBER,phoneVerify);
                            if(f==0){
                                loggedIn.putExtra("studentname", studentname);
                                loggedIn.putExtra("studentroll", studentroll);
                                loggedIn.putExtra("studentclass", studentclass);
                                loggedIn.putExtra("studentphone", phoneNumber);
                            }

                            startActivity(loggedIn);

                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Toast.makeText(otpverify.this,"error",Toast.LENGTH_LONG).show();
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }
    private void timer()
    {
        if(otpFlag ==0)
        {
            new CountDownTimer(60000, 1000) {
                public void onTick(long millisUntilFinished) {
                    if(otpFlag ==0)
                        mOtpTimer.setText( ""+millisUntilFinished / 1000);
                }
                public void onFinish() {
                    mOtpTimer.setText("0");
                    otpFlag =1;
                }

            }.start();
        }
        else
        {
            new CountDownTimer(60000, 1000) {
                public void onTick(long millisUntilFinished) {
                    mOtpTimer.setText( ""+millisUntilFinished / 1000);
                }
                public void onFinish() {

                }

            }.start();
        }
    }

}
