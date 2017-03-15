package com.example.everyoneassist.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.everyoneassist.Adapter.MyCollectAdapter;
import com.example.everyoneassist.R;

public class MyCollectActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        initHeader("我的收藏");

        initView();
    }

    private ListView collect_list;

    private void initView() {
        collect_list = (ListView) this.findViewById(R.id.collect_list);

        collect_list.setAdapter(new MyCollectAdapter(this));
    }


}
