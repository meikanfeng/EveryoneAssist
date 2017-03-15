package com.example.everyoneassist.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.ScreenUtils;

import org.xutils.common.util.DensityUtil;

/**
 * Created by fengm on 2017-3-5.
 */

public class MyListView extends ListView {

    private Context context;

    public MyListView(Context context) {
        super(context);
        init(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init(context);
    }

    private TextView footer;

    private void init(Context context) {
        this.context = context;

        footer = new TextView(context);
        footer.setText("------这是底线------");
        footer.setGravity(Gravity.CENTER);
        addFooterView(footer);
    }

    public void setbottom(int bottom){
        footer.setPadding(10,10,10,bottom);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }
}
