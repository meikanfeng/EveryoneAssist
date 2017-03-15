package com.example.everyoneassist.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.everyoneassist.Activity.EditSkillActivity;
import com.example.everyoneassist.Activity.SkillManagerActivity;
import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.HttpPostRequestUtils;
import com.example.everyoneassist.View.MyHorizontalScrollView;

import java.util.HashMap;

/**
 * Created by fengm on 2017/1/13.
 */

public class SkillAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;
    private HttpPostRequestUtils.HttpPostRequestCallback hprc;

    private final String METHOD_DEL_SERVER = "del_server";  //删除技能
    private final String METHOD_OFF_SERVER = "off_server";  //关闭技能

    public SkillAdapter(HttpPostRequestUtils.HttpPostRequestCallback hprc) {
        this.context = hprc.getContext();
        this.hprc = hprc;
    }

    @Override
    public int getCount() {
        return 2;
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
            if (context instanceof SkillManagerActivity)
                convertView = LayoutInflater.from(context).inflate(R.layout.skillmanageradapter_item, null, false);
            else convertView = LayoutInflater.from(context).inflate(R.layout.skilladapter_item, null, false);
            viewholder = new ViewHolder();
            viewholder.amend_skill = (TextView) convertView.findViewById(R.id.amend_skill);
            viewholder.close_skill = (TextView) convertView.findViewById(R.id.close_skill);
            viewholder.delete_skill = (TextView) convertView.findViewById(R.id.delete_skill);
            viewholder.imagelist = (MyHorizontalScrollView) convertView.findViewById(R.id.imagelist);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.amend_skill.setTag("11");
        viewholder.close_skill.setTag("11");
        viewholder.delete_skill.setTag("11");
        viewholder.amend_skill.setOnClickListener(this);
        viewholder.close_skill.setOnClickListener(this);
        viewholder.delete_skill.setOnClickListener(this);
        viewholder.imagelist.setVisibility(View.GONE);
//        viewholder.imagelist.setAdapter(new SkillImageAdapter(context, 2, null));

        return convertView;
    }

    @Override
    public void onClick(View v) {
        HashMap<String, String> map = new HashMap<String, String>();
        switch (v.getId()){
            case R.id.amend_skill:
                Intent intent = new Intent(context, EditSkillActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra("skill_type", 1);
                intent.putExtra("skill_id", (String) v.getTag());
                context.startActivity(intent);
                break;
            case R.id.close_skill:
                map.put("act", METHOD_OFF_SERVER);
                map.put("user_id", context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("user_id", ""));
                map.put("skill_id", (String) v.getTag());
                HttpPostRequestUtils.getInstance(hprc).Post(map);
                break;
            case R.id.delete_skill:
                map.put("act", METHOD_DEL_SERVER);
                map.put("user_id", context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("user_id", ""));
                map.put("skill_id", (String) v.getTag());
                HttpPostRequestUtils.getInstance(hprc).Post(map);
                break;
        }
    }

    class ViewHolder {
        TextView amend_skill, close_skill, delete_skill;
        MyHorizontalScrollView imagelist;
    }

}
