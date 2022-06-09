package com.example.project11_1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private final ArrayList<ListViewItem> arrayList;

    public ListViewAdapter(ArrayList<ListViewItem> data) {
        this.arrayList = data;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
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

            view = inflater.inflate(R.layout.listview_item, viewGroup, false);

            ImageView iconImageView = view.findViewById(R.id.imageView1);
            TextView titleTextView = view.findViewById(R.id.textView1);
            TextView descTextView = view.findViewById(R.id.textView2);

            ListViewItem item = arrayList.get(i);

            iconImageView.setImageDrawable(item.getIconDrawable());
            titleTextView.setText(item.getTitleStr());
            descTextView.setText(item.getDescStr());
        }

        return view;
    }
}

class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String descStr;

    public ListViewItem(Drawable drawable, String title, String description) {
        this.iconDrawable = drawable;
        this.titleStr = title;
        this.descStr = description;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getDescStr() {
        return descStr;
    }

    public void setDescStr(String descStr) {
        this.descStr = descStr;
    }
}