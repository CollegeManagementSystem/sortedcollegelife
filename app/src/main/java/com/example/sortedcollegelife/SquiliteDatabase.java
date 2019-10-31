package com.example.sortedcollegelife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class SquiliteDatabase extends SQLiteOpenHelper {

    private static final String Database_Name="TIMETABLE.db";
    private static final String Table_Name="TIMETABLE_Info";
    private static final String newtableName="chatbox";
    SQLiteDatabase mdatabase;
    public SquiliteDatabase(Context context) {
        super(context,Database_Name,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_Name+" (DAY TEXT,CLASS1 TEXT,CLASS2 TEXT,CLASS3 TEXT," +
                "CLASS4 TEXT,CLASS5 TEXT,CLASS6 TEXT,CLASS7 TEXT,CLASS8 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean adddetails(String Day,String Class1,String Class2,String Class3,String Class4,
                              String Class5,String Class6,String Class7,String Class8){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("DAY",Day);
        contentvalues.put("CLASS1",Class1);
        contentvalues.put("CLASS2",Class2);
        contentvalues.put("CLASS3",Class3);
        contentvalues.put("CLASS4",Class4);
        contentvalues.put("CLASS5",Class5);
        contentvalues.put("CLASS6",Class6);
        contentvalues.put("CLASS7",Class7);
        contentvalues.put("CLASS8",Class8);
        long result=db.insert(Table_Name,null,contentvalues);
        return true;
    }
    public Cursor fetch(String Day,String classnumber){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="Select * from "+Table_Name+"";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
}
