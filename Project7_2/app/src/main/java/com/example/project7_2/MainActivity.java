package com.example.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    DialogFragment dialogFragment = new DialogFragment();
    CustomDialogFragment customDialogFragment = new CustomDialogFragment();
    MoreFragment moreFragment = new MoreFragment();
    AddFragment addFragment = new AddFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frameLayout, dialogFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.menu_dialog:
                        transaction.replace(R.id.menu_frameLayout, dialogFragment).commit();
                        break;
                    case R.id.menu_custom_dialog:
                        transaction.replace(R.id.menu_frameLayout, customDialogFragment).commit();
                        break;
                    case R.id.menu_more:
                        transaction.replace(R.id.menu_frameLayout, moreFragment).commit();
                        break;
                    case R.id.menu_add:
                        transaction.replace(R.id.menu_frameLayout, addFragment).commit();
                        break;
                }

                return true;
            }
        });
    }
}