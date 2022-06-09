package com.example.project12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("mydatabase.db", Context.MODE_PRIVATE, null);
        // 테이블 추가
        String sql = "CREATE TABLE student(id Integer PRIMARY KEY AUTOINCREMENT, name Text, mobile Text);";
        db.execSQL(sql);
        // 레코드 추가
        db.execSQL("INSERT INTO student(name, mobile) VALUES ('kim', '010-1234-5678');");
        db.execSQL("INSERT INTO student(name, mobile) VALUES ('lee', '010-4455-5678');");
    }
}