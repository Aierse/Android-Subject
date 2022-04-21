package com.example.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioGroup rdoGroup;
    Chronometer chr;
    CalendarView calendarView;
    Button btnStart, btnEnd;
    TimePicker timePicker;
    TextView textView1;

    int selectYear, selectMonth, selectDay;
    int selectHour, selectMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoGroup = findViewById(R.id.rdoGroup);
        chr = findViewById(R.id.chronometer1);
        calendarView = findViewById(R.id.calendarView1);
        timePicker = findViewById(R.id.timePicker1);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        textView1 = findViewById(R.id.textView1);

        RadioButton rdoCal = findViewById(R.id.rdoCal);
        RadioButton rdoTime = findViewById(R.id.rdoTime);

        calendarView.setVisibility(View.INVISIBLE);

        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rdoCal:
                        calendarView.setVisibility(View.VISIBLE);
                        timePicker.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rdoTime:
                        calendarView.setVisibility(View.INVISIBLE);
                        timePicker.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = day;
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int time, int minute) {
                selectHour = time;
                selectMinute = minute;
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr.setBase(SystemClock.elapsedRealtime());
                chr.start();
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr.stop();
                textView1.setText(String.format("예약 시간 : %d년 %d월 %d일 %d시 %d분", selectYear, selectMonth, selectDay, selectHour, selectMinute));
            }
        });
    }
}