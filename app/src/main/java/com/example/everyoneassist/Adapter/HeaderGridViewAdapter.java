package com.example.everyoneassist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.everyoneassist.Entity.HomeCategory;
import com.example.everyoneassist.R;

import java.util.List;

/**
 * Created by fengm on 2017/1/12.
 */

public class HeaderGridViewAdapter extends BaseAdapter {

    private String[] item;
    private Context context;
    private int max = 0;

    public HeaderGridViewAdapter(Context context, List<HomeCategory> items, int max) {
        this.context = context;
        this.max = max;
        if (items == null) {
            this.item = context.getResources().getStringArray(R.array.need_item);
            return;
        }
        this.item = new String[items.size()];
        for (int i = 0; i < items.size(); i ++){
            this.item[i] = items.get(i).getCat_name();
        }
    }

    public HeaderGridViewAdapter(Context context, List<HomeCategory> items) {
        this.context = context;
        if (items == null) {
            this.item = context.getResources().getStringArray(R.array.need_item);
            return;
        }
        this.item = new String[items.size()];
        for (int i = 0; i < items.size(); i ++){
            this.item[i] = items.get(i).getCat_name();
        }
    }

    public HeaderGridViewAdapter(Context context, String[] item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        if (max != 0)
            if (item.length > max) return max;
        return item.length;
    }

    @Override
    public Object getItem(int position) {
        return item[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.headergridviewadapter_item, null, false);
        TextView textview = (TextView) view.findViewById(R.id.gridview_text);
        textview.setText(item[position]);
        return view;
    }
}
