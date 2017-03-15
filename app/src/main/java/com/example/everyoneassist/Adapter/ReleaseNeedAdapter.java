package com.example.everyoneassist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.everyoneassist.R;
import com.example.everyoneassist.View.MyGridView;

/**
 * Created by fengm on 2017/1/13.
 */
public class ReleaseNeedAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private OnItemClickListener itemclick;

    public ReleaseNeedAdapter(OnItemClickListener itemclick) {
        this.itemclick = itemclick;
        this.context = itemclick.getContext();
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
        ViewHolder viewholder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.releaseneedadapter_item, null, false);
            viewholder = new ViewHolder();
            viewholder.need_title = (TextView) convertView.findViewById(R.id.need_title);
            viewholder.need_gridview = (MyGridView) convertView.findViewById(R.id.need_gridview);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        String[] items = context.getResources().getStringArray(R.array.need_item);
        viewholder.need_gridview.setAdapter(new HeaderGridViewAdapter(context, null));
        viewholder.need_gridview.setOnItemClickListener(this);
        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        itemclick.ItemClick(view, position, id);
    }

    class ViewHolder {
        TextView need_title;
        MyGridView need_gridview;
    }

    public interface OnItemClickListener{
        void ItemClick(View view, int position, long id);
        Context getContext();
    }

}
