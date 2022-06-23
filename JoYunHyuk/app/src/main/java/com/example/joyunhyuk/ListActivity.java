package com.example.joyunhyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myDBHelper = new MyDBHelper(this);

        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT email, pwd FROM student", null);

        while (cursor.moveToNext()) {
            email.add(cursor.getString(0));
            password.add(cursor.getString(1));
        }


    }
}