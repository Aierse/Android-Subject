package com.example.project11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DynamicActivity extends AppCompatActivity {
    EditText edtName;
    Button btnInsert, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        setTitle("동적리스트뷰");

        ArrayList<String> item = new ArrayList<>();

        edtName = findViewById(R.id.edtName);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);

        ListView dynamicListView = findViewById(R.id.dynamicListView);
        dynamicListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, item);
        dynamicListView.setAdapter(adapter);

        btnInsert.setOnClickListener(view -> {
            item.add(edtName.getText().toString());
            edtName.setText("");
            adapter.notifyDataSetChanged();
        });
        btnDelete.setOnClickListener(view -> {
            //item.remove(dynamicListView.getSelectedItemPosition());
            adapter.notifyDataSetChanged();
        });
    }
}