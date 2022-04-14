package com.example.project5_1;

<<<<<<< HEAD
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragActivity extends AppCompatActivity {
    Fragment fragment1, fragment2, fragment3;
=======
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class FragActivity extends Fragment {
>>>>>>> 47d84819fadb929b2fc751b0d16e95583fe6c162

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
<<<<<<< HEAD

        fragment1 = new OneFragment();
        fragment2 = new TwoFragment();
        fragment3 = new ThreeFragment();

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragment1).commit();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragment2).commit();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragment3).commit();
            }
        });
=======
>>>>>>> 47d84819fadb929b2fc751b0d16e95583fe6c162
    }
}