package com.example.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FrameActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    Button btn1, btn2, btn3;
    FrameLayout frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        frame = findViewById(R.id.frameLayout);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        frame.removeView(tv2);
        frame.removeView(tv3);

        View.OnClickListener btnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frame.removeAllViews();

                switch (view.getId()) {
                    case R.id.btn1:
                        frame.addView(tv1);
                        break;
                    case R.id.btn2:
                        frame.addView(tv2);
                        break;
                    case R.id.btn3:
                        frame.addView(tv3);
                        break;
                }
            }
        };

        btn1.setOnClickListener(btnClick);
        btn2.setOnClickListener(btnClick);
        btn3.setOnClickListener(btnClick);
    }
}