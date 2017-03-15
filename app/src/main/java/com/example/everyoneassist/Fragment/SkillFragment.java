package com.example.everyoneassist.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.everyoneassist.Adapter.SkillAdapter;
import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.HttpPostRequestUtils;
import com.example.everyoneassist.Utils.ScreenUtils;
import com.example.everyoneassist.View.MyListView;

import org.json.JSONObject;
import org.xutils.common.util.DensityUtil;


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
        skillAdapter = new SkillAdapter(this);
        skilllistview.setAdapter(skillAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void Success(String method, JSONObject json) {

    }

    @Override
    public void Fail(String method, String error) {

    }

}
