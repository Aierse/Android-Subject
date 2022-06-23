package com.example.joyunhyuk;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    myDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new myDBHelper(this);

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
        }
    });

    private void insertStudent(String dno, String name, String tel, String email, String password) {
        SQLiteDatabase db = myDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("dno", dno);
        values.put("name", name);
        values.put("name", tel);
        values.put("name", email);
        values.put("name", password);

        db.insert("student", null, values);

        db.close();
    }

    static class myDBHelper extends SQLiteOpenHelper {
        //생성자를 통해 DB 생성
        public myDBHelper(Context context) {
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
}