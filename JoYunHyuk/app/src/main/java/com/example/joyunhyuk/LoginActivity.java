package com.example.joyunhyuk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    MyDBHelper myDBHelper;
    EditText inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDBHelper = new MyDBHelper(this);

        Button confirm = findViewById(R.id.confirm);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);

        confirm.setOnClickListener(view -> {
            SQLiteDatabase db = myDBHelper.getReadableDatabase();

            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();
            //결과가 있는지 확인
            Cursor cursor = db.rawQuery("SELECT * FROM groupTBL WHERE email = " + email + "AND pwd = " + password + ";", null);

            // 결과가 있으면 로그인 성공
            AlertDialog.Builder dialog = new AlertDialog.Builder(getBaseContext());
            dialog.setIcon(R.drawable.ic_launcher_foreground);

            if (cursor.moveToFirst()) {
                dialog.setTitle("로그인 성공!");
                dialog.setMessage("다음 화면으로 이동하시겠습니까?");

                dialog.setPositiveButton("확인", (dialogInterface, i) -> {
                    Intent outIntent = new Intent(LoginActivity.this, MainActivity.class);
                    setResult(RESULT_OK, outIntent);

                    finish();
                });

                dialog.setNegativeButton("취소", (dialogInterface, i) -> {

                });
            }
            else {
                dialog.setTitle("로그인 실패!");
                dialog.setMessage("이메일과 패스워드를 확인하세요.");

                dialog.setPositiveButton("확인", (dialogInterface, i) -> {

                });

                dialog.setNegativeButton("취소", (dialogInterface, i) -> {

                });
            }
        });
    }
}