package com.example.sortedcollegelife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

   public class studentdatabase extends SQLiteOpenHelper{

       private static final String Database_Name="CollegeRecord.db";
       private static final String Table_Name1="Student_Info";
       private static final String Table_Name2="Teacher_Info";
       private static final String Table_Name3="Student_Attendence";
       private static final String Table_Name4="Time_table";
       SQLiteDatabase mdatabase;
       public studentdatabase(Context context ,String mtable_Name) {
           super(context,Database_Name,null, 1);
           SQLiteDatabase db=this.getWritableDatabase();
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           db.execSQL("create table "+Table_Name1+" (Student_name TEXT,Student_Roll TEXT,Contact TEXT,Class TEXT)");
           db.execSQL("create table "+Table_Name2+" (Teacher_name TEXT,Teacher_ID TEXT,Contact TEXT)");
           db.execSQL("create table "+Table_Name3+" (Student_name TEXT,Student_Roll TEXT,Contact TEXT,Attendence INT)");
           db.execSQL("create table "+Table_Name1+" (DAY TEXT,Lecture1 TEXT,Lecture2 TEXT,Lecture3 TEXT,Lecture4 TEXT,Lecture5 TEXT,Lecture6 TEXT,Lecture7 TEXT,Lecture8 TEXT)");
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       }
       /*public boolean addStudent(String name,String Roll_number,String Contact,String Class){
           SQLiteDatabase db=this.getWritableDatabase();
           ContentValues contentValues=new ContentValues();
           String query="Select Contacts from "+Table_Name+" where Contacts='"+new_Contact+"'";
           Cursor cursor=db.rawQuery(query,null);
           long result=0;
           if(cursor.getCount()<=0)
           {
               contentValues.put("Main_user",Main_user);
               contentValues.put("Contacts",new_Contact );
               result=db.insert(Table_Name,null,contentValues);
           }
           if(result==-1)
               return false;
           else
               return true;
       }*/

   }
