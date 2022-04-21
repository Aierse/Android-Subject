package com.example.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioGroup rdoGroup;
    Chronometer chr;
    CalendarView cal;
    Button btnStart, btnEnd;
    TimePicker timePicker;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoGroup = findViewById(R.id.rdoGroup);
        chr = findViewById(R.id.chronometer1);
        cal = findViewById(R.id.calendarView1);
        timePicker = findViewById(R.id.timePicker1);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        textView1 = findViewById(R.id.textView1);

        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rdoCal:
                        cal.setVisibility(View.VISIBLE);
                        timePicker.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rdoTime:
                        cal.setVisibility(View.INVISIBLE);
                        timePicker.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}