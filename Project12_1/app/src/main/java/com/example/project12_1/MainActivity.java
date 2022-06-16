package com.example.project12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    myDBHelper myDBHelper;
    SQLiteDatabase db;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect, btnUpdate, btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myDBHelper = new myDBHelper(this);
        
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);

        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

//        btnInsert.setOnClickListener(view -> {
//            db = myDBHelper.getWritableDatabase();
//            db.execSQL("INSERT INTO groupTBL VALUES('" + edtName.getText().toString() + "'," + edtNumber.getText().toString() + ");");
//
//            db.close();
//
//            edtName.setText("");
//            edtNumber.setText("");
//
//            InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//            im.hideSoftInputFromWindow(edtName.getWindowToken(), 0);
//
//            edtName.requestFocus();
//            Toast.makeText(this, "입력완료", Toast.LENGTH_SHORT).show();
//        });

        btnInsert.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("gName", edtName.getText().toString());
            values.put("gNumber", edtNumber.getText().toString());

            db.insert("groupTBL", null, values);

            db.close();

            edtName.setText("");
            edtNumber.setText("");

            deleteKeypad();

            edtName.requestFocus();
        });

        btnSelect.setOnClickListener(view -> {
            db = myDBHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM groupTBL;", null);

            edtNameResult.setText("그룹이름\n--------------\n");
            edtNumberResult.setText("그룹인원\n--------------\n");

            while(cursor.moveToNext()) {
                edtNameResult.setText(String.format("%s%s\n", edtNameResult.getText(), cursor.getString(0)));
                edtNumberResult.setText(String.format("%s%s\n", edtNumberResult.getText(), cursor.getString(1)));
            }

            cursor.close();
            db.close();
        });

        btnInit.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();
            myDBHelper.onUpgrade(db, 1, 2);

            db.close();
            btnSelect.callOnClick();
        });

        btnDelete.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();

            if (edtName.getText().toString() != "")
                db.execSQL("DELETE FROM groupTBL WHERE gName = '" + edtName.getText().toString() + "';");

            db.close();

            deleteKeypad();
            btnSelect.callOnClick();
        });

        btnUpdate.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();

            if (edtName.getText().toString() != "")
                db.execSQL("UPDATE groupTBL SET gNumber = " + edtNumber.getText().toString() + " WHERE gName = '" + edtName.getText().toString() + "';");

            db.close();

            deleteKeypad();
            btnSelect.callOnClick();
        });
    }

    private void deleteKeypad() {
        InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(edtName.getWindowToken(), 0);
    }

    public class myDBHelper extends SQLiteOpenHelper {
        //생성자를 통해 DB 생성
        public myDBHelper(Context context) {
            super(context, "groupDB.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL(gName char(20) PRIMARY KEY, gNumber integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}