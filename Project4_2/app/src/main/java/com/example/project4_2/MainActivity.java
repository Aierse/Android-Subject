package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 선호도 조사");

        Switch start = (Switch) findViewById(R.id.start);

        TextView favorite = (TextView) findViewById(R.id.favorite);
        RadioGroup select = (RadioGroup) findViewById(R.id.select);
        ImageView imgPrint = (ImageView) findViewById(R.id.imgprint);

        Button exit = (Button) findViewById(R.id.exit);
        Button reset = (Button) findViewById(R.id.reset);

        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    favorite.setVisibility(View.VISIBLE);
                    select.setVisibility(View.VISIBLE);
                }
                else {
                    favorite.setVisibility(View.INVISIBLE);
                    select.setVisibility(View.INVISIBLE);
                    imgPrint.setVisibility(View.INVISIBLE);
                }
            }
        });

        select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                imgPrint.setVisibility(View.VISIBLE);
                switch (i) {
                    case R.id.dog:
                        imgPrint.setImageResource(R.drawable.dog);
                        break;
                    case R.id.cat:
                        imgPrint.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rabbit:
                        imgPrint.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPrint.setVisibility(View.INVISIBLE);
                select.clearCheck();
                start.setChecked(false);
            }
        });
    }
}