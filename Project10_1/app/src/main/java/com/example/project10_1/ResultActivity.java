package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");

        int voteCount[] = getIntent().getIntArrayExtra("VoteCount");
        String[] imageName = getIntent().getStringArrayExtra("ImageName");

        RatingBar[] bar = new RatingBar[] {
                findViewById(R.id.rBar1), findViewById(R.id.rBar2), findViewById(R.id.rBar3),
                findViewById(R.id.rBar4), findViewById(R.id.rBar5), findViewById(R.id.rBar6),
                findViewById(R.id.rBar7), findViewById(R.id.rBar8), findViewById(R.id.rBar9)};

        TextView[] tv = new TextView[] {
                findViewById(R.id.tv1),findViewById(R.id.tv2),findViewById(R.id.tv3),
                findViewById(R.id.tv4),findViewById(R.id.tv5),findViewById(R.id.tv6),
                findViewById(R.id.tv7),findViewById(R.id.tv8),findViewById(R.id.tv9),
        };

        for (int i = 0; i < bar.length; i++) {
            tv[i].setText(imageName[i]);
            bar[i].setRating(voteCount[i]);
        }

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}