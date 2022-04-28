package com.example.project7_1;

import android.graphics.Color;
import android.os.Bundle;

import com.example.project7_1.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    private AppBarConfiguration appBarConfiguration;
    ConstraintLayout firstFragment1;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        firstFragment1 = findViewById(R.id.FirstFragment1);

        registerForContextMenu(firstFragment1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();

        if (v == firstFragment1) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.context1_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Button btn = findViewById(R.id.button_first);

        switch (item.getItemId()) {
            case R.id.subRotate:
                btn.setRotation(45);
                break;
            case R.id.subSize:
                btn.setWidth(btn.getWidth() * 2);
                btn.setHeight(btn.getHeight() * 2);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        // 메뉴 아이템 중에서 검색을 위해 정의한 아이템을 뷰 객체로 참조
        LinearLayout view = (LinearLayout)menu.findItem(R.id.search_button).getActionView();

        EditText edit = view.findViewById(R.id.editText);

        edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Toast.makeText(getApplicationContext(), "입력되었습니다.", Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        coordinatorLayout = findViewById(R.id.coordinator1);

        switch (item.getItemId()) {
            case R.id.itemRed:
                binding.coordinator1.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                binding.coordinator1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                binding.coordinator1.setBackgroundColor(Color.BLUE);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}