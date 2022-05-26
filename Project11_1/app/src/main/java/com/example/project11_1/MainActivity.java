package com.example.project11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 뷰");

        String[] array = { "리스트 동적 추가", "커스텀 리스트 뷰", "이순신", "유관순", "강아지" };

        ListView listView = findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, array);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            Intent intent;

            switch (position) {
                case 0:
                    intent = new Intent(MainActivity.this, DynamicActivity.class);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, CustomActivity.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }

            startActivity(intent);
        });
    }
}