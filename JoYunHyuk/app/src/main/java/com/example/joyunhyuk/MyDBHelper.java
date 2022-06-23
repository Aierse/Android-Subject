package com.example.joyunhyuk;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDBHelper extends SQLiteOpenHelper {
    //생성자를 통해 DB 생성
    public MyDBHelper(Context context) {
        super(context, "student_information.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(dno char(8) PRIMARY KEY, name char(5) NOT NULL, tel char(11), email char(30) NOT NULL, pwd char(10) NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }
}
