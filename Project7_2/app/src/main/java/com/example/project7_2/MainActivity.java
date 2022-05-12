package com.example.project7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DialogFragment dialogFragment = new DialogFragment();
    CustomDialogFragment customDialogFragment = new CustomDialogFragment();
    MoreFragment moreFragment = new MoreFragment();
    AddFragment addFragment = new AddFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}