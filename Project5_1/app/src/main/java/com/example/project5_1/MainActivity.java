package com.example.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        linearLayout = new LinearLayout(this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.CYAN);

        Button btn = new Button(this);

        btn.setText("추가");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = new TextView(MainActivity.this);

                tv.setBackgroundColor(Color.YELLOW);

                LinearLayout.LayoutParams tvLayoutParams = new LinearLayout.LayoutParams(200, 200);
                tvLayoutParams.setMargins(10, 10, 10, 10);
                linearLayout.addView(tv, tvLayoutParams);
            }
        });

        LinearLayout.LayoutParams btnLayoutParams = new LinearLayout.LayoutParams(200, 200);
        linearLayout.addView(btn, btnLayoutParams);

        Button move = new Button(this);
        move.setText("액티비티 이동");
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RelativeActivity.class);

                startActivity(i);
            }
        });

        LinearLayout.LayoutParams moveLayoutParams = new LinearLayout.LayoutParams(200, 200);
        linearLayout.addView(move, moveLayoutParams);

        //프레임 액티비티 이동
        Button framemove = new Button(this);
        framemove.setText("프레임 액티비티 이동");
        framemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FrameActivity.class);

                startActivity(i);
            }
        });

        LinearLayout.LayoutParams frameLayoutParams = new LinearLayout.LayoutParams(200, 200);
        linearLayout.addView(framemove, frameLayoutParams);

        setContentView(linearLayout);
    }
}