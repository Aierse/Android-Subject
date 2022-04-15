package com.example.project5_18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.firstOperand);
        second = findViewById(R.id.secondOperand);
    }

    public void numberSelect(View view) {
        EditText focused = first.hasFocus() ? first : second.hasFocus() ? second : null;

        if (focused == null) {
            Toast.makeText(this, "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(focused.getText().toString() + ((Button)view).getText());

        focused.setText(Long.toString(value));
    }
}