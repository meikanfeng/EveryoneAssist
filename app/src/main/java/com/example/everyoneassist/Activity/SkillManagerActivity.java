package com.example.everyoneassist.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.everyoneassist.Adapter.SkillAdapter;
import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.HttpPostRequestUtils;
import com.example.everyoneassist.Utils.ScreenUtils;
import com.example.everyoneassist.View.MyListView;

import org.json.JSONObject;
import org.xutils.common.util.DensityUtil;

public class SkillManagerActivity extends BaseActivity implements View.OnClickListener, HttpPostRequestUtils.HttpPostRequestCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_manager);
        initHeader("技能管理");
        setRightImg(R.mipmap.skills_management_03);
        right_img.setOnClickListener(this);

        initView();
    }

    private MyListView skilllistview;
    private SkillAdapter skillAdapter;

    private void initView() {
        skilllistview = (MyListView) this.findViewById(R.id.skilllistview);
        skilllistview.setbottom(DensityUtil.dip2px(15));
        skillAdapter = new SkillAdapter(this);
        skilllistview.setAdapter(skillAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.right_img:
                startActivity(new Intent(this, AddSkillListActivity.class));
                break;
        }
    }

    @Override
    public void Success(String method, JSONObject json) {

    }

    @Override
    public void Fail(String method, String error) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
