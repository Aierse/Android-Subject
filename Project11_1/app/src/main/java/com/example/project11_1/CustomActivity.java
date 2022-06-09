package com.example.project11_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        setTitle("커스텀 리스트뷰");

        ArrayList<ListViewItem> data = new ArrayList<>();

        data.add(new ListViewItem(ContextCompat.getDrawable(this, R.drawable.cat), "고양이", "고양이입니다."));
        data.add(new ListViewItem(ContextCompat.getDrawable(this, R.drawable.dog), "강아지", "강아지입니다."));
        data.add(new ListViewItem(ContextCompat.getDrawable(this, R.drawable.rabbit), "토끼", "토끼입니다."));

        ListView customListView = findViewById(R.id.customListView);
        ListViewAdapter adapter = new ListViewAdapter(data);

        customListView.setAdapter(adapter);
    }
}