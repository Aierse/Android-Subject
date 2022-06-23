package com.example.joyunhyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myDBHelper = new MyDBHelper(this);

        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT email, pwd FROM student", null);

        while (cursor.moveToNext()) {
            email.add(cursor.getString(0));
            password.add(cursor.getString(1));
        }

        ListView listView = findViewById(R.id.itemListView);
        listView.setAdapter(new ListViewAdapter(email, password));
    }
}

class ListViewAdapter extends BaseAdapter {
    private final ArrayList<String> email;
    private final ArrayList<String> password;

    public ListViewAdapter(ArrayList<String> email, ArrayList<String> password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public int getCount() {
        return email.size();
    }

    @Override
    public Object getItem(int i) {
        return email.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_item, viewGroup, false);

            TextView emailTextView = view.findViewById(R.id.itemEmail);
            TextView passwordTextView = view.findViewById(R.id.itemPassword);

            emailTextView.setText(email.get(i));
            passwordTextView.setText(password.get(i));
        }

        return view;
    }
}