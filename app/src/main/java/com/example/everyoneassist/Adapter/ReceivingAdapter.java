package com.example.everyoneassist.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.everyoneassist.R;

/**
 * Created by fengm on 2017/1/13.
 */

public class ReceivingAdapter extends BaseAdapter {

    private Context context;

    public ReceivingAdapter(Context context) {
        this.context =context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.receivingadapter_item, null, false);
            viewHolder = new ViewHolder();
            viewHolder.listview_title = (TextView) convertView.findViewById(R.id.listview_title);
            viewHolder.receiving_content = (TextView) convertView.findViewById(R.id.receiving_content);
            viewHolder.receiving_time = (TextView) convertView.findViewById(R.id.receiving_time);
            viewHolder.receiving_price = (TextView) convertView.findViewById(R.id.receiving_price);
            viewHolder.receiving_addr_buy = (TextView) convertView.findViewById(R.id.receiving_addr_buy);
            viewHolder.receiving_addr_sell = (TextView) convertView.findViewById(R.id.receiving_addr_sell);
            viewHolder.receiving_name = (TextView) convertView.findViewById(R.id.receiving_name);
            viewHolder.receiving_phone = (TextView) convertView.findViewById(R.id.receiving_phone);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) viewHolder.listview_title.setVisibility(View.VISIBLE);
        else viewHolder.listview_title.setVisibility(View.GONE);
        return convertView;
    }
    class ViewHolder{
        TextView listview_title, receiving_content, receiving_time, receiving_price, receiving_addr_buy, receiving_addr_sell, receiving_name, receiving_phone;
    }

}
