package com.example.joyunhyuk;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new MyDBHelper(this);
        myDBHelper.onUpgrade(myDBHelper.getWritableDatabase(), 1, 2);

        // 테스트 데이터 추가
        insertStudent("1234", "홍길동", "010-1234-3287", "hong@gmail.com", "1234!");
        insertStudent("5678", "박문수", "011-3333-2222", "park@gmail.com", "5678!");
        insertStudent("9012", "이순신", "010-9999-2222", "lee@gmail.com", "9012!");
        // 내 데이터 추가
        insertStudent("20174434", "조윤혁", "010-3916-0577", "dbsgur2008@naver.com", "1234!");
        // 로그인 액티비티 실행
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        mStartForResult.launch(intent);
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);

            startActivity(intent);
        }
    });

    private void insertStudent(String dno, String name, String tel, String email, String password) {
        SQLiteDatabase db = myDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("dno", dno);
        values.put("name", name);
        values.put("tel", tel);
        values.put("email", email);
        values.put("pwd", password);

        db.insert("student", null, values);

        db.close();
    }
}