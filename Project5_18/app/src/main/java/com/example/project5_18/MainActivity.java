package com.example.project5_18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first, second;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.firstOperand);
        second = findViewById(R.id.secondOperand);

        result = findViewById(R.id.result);
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

    public void sum(View view) {
        String firstValue = first.getText().toString();
        String secondValue = second.getText().toString();

        if (firstValue.equals("") || secondValue.equals("")) {
            Toast.makeText(this, "값이 비었습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(firstValue) + Long.parseLong(secondValue);
        result.setText("계산결과 : " + value);
    }

    public void sub(View view) {
        String firstValue = first.getText().toString();
        String secondValue = second.getText().toString();

        if (firstValue.equals("") || secondValue.equals("")) {
            Toast.makeText(this, "값이 비었습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(firstValue) - Long.parseLong(secondValue);
        result.setText("계산결과 : " + value);
    }

    public void mul(View view) {
        String firstValue = first.getText().toString();
        String secondValue = second.getText().toString();

        if (firstValue.equals("") || secondValue.equals("")) {
            Toast.makeText(this, "값이 비었습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(firstValue) * Long.parseLong(secondValue);
        result.setText("계산결과 : " + value);
    }

    public void div(View view) {
        String firstValue = first.getText().toString();
        String secondValue = second.getText().toString();

        if (firstValue.equals("") || secondValue.equals("")) {
            Toast.makeText(this, "값이 비었습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Long.parseLong(secondValue) == 0) {
            Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(firstValue) / Long.parseLong(secondValue);
        result.setText("계산결과 : " + value);
    }

    public void mod(View view) {
        String firstValue = first.getText().toString();
        String secondValue = second.getText().toString();

        if (firstValue.equals("") || secondValue.equals("")) {
            Toast.makeText(this, "값이 비었습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Long.parseLong(secondValue) == 0) {
            Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(firstValue) % Long.parseLong(secondValue);
        result.setText("계산결과 : " + value);
    }
}