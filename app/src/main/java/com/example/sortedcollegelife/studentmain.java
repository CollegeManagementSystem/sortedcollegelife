package com.example.sortedcollegelife;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.util.List;

public class studentmain extends AppCompatActivity {

    ImageButton mytimetable, mytimetanble1;
    Bitmap imageBitmap;
    EditText mytimetabletext;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentmain);
        mytimetable = findViewById(R.id.timetable);
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
        });
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
    }*/
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
    }
}
