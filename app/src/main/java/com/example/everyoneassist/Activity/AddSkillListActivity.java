package com.example.everyoneassist.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.everyoneassist.Adapter.ReleaseNeedAdapter;
import com.example.everyoneassist.R;

public class AddSkillListActivity extends BaseActivity implements ReleaseNeedAdapter.OnItemClickListener {

    private ListView need_listview;
    private ReleaseNeedAdapter releaseNeedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skill_list);
        initHeader("添加技能");

        initView();
    }

    private void initView() {
        need_listview = (ListView) this.findViewById(R.id.need_listview);
        releaseNeedAdapter = new ReleaseNeedAdapter(this);
        need_listview.setAdapter(releaseNeedAdapter);

    }

    @Override
    public void ItemClick(View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), EditSkillActivity.class);
        intent.putExtra("type", 0);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
