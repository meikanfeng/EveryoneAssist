package com.example.everyoneassist.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.everyoneassist.Adapter.SkillAdapter;
import com.example.everyoneassist.Entity.Skill;
import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.DebugLog;
import com.example.everyoneassist.Utils.HttpPostRequestUtils;
import com.example.everyoneassist.Utils.ScreenUtils;
import com.example.everyoneassist.View.MyListView;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.util.DensityUtil;

import java.util.HashMap;
import java.util.List;


public class SkillFragment extends Fragment implements HttpPostRequestUtils.HttpPostRequestCallback {

    public SkillFragment() {
        // Required empty public constructor
    }

    public static SkillFragment newInstance() {
        SkillFragment fragment = new SkillFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private MyListView skilllistview;
    private SkillAdapter skillAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill, container, false);
        skilllistview = (MyListView) view.findViewById(R.id.skilllistview);
        int bottom = (int)((float) ScreenUtils.getScreenWidth(getActivity()) * 0.18f) - DensityUtil.dip2px(45);
        skilllistview.setbottom(bottom);
        getSkill();
        return view;
    }

    private final String METHOD_SKILL = "skill_list";

    private void getSkill() {
        HashMap<String, String> map = new HashMap<>();
        map.put("act", METHOD_SKILL);
        map.put("user_id", "5");
        map.put("page","1");
        HttpPostRequestUtils.getInstance(this).Post(map);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private List<Skill> skills;

    @Override
    public void Success(String method, JSONObject json) throws JSONException {
        if (METHOD_SKILL.equals(method)){
            skills = JSON.parseArray(json.getString("data"), Skill.class);
            skillAdapter = new SkillAdapter(this, skills);
            skilllistview.setAdapter(skillAdapter);
        }
    }

    @Override
    public void Fail(String method, String error) {
        DebugLog.d("XXXXXXXXXXXX","sssssssssssssss");
    }

}
