package com.example.everyoneassist.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.everyoneassist.Activity.AtWillBuyActivity;
import com.example.everyoneassist.Adapter.HeaderGridViewAdapter;
import com.example.everyoneassist.Adapter.HomeAdapter;
import com.example.everyoneassist.Adapter.SectionsPagerAdapter;
import com.example.everyoneassist.Entity.HomeCategory;
import com.example.everyoneassist.Entity.Skill;
import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.HttpPostRequestUtils;
import com.example.everyoneassist.Utils.ScreenUtils;
import com.example.everyoneassist.View.MyListView;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.util.DensityUtil;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;


public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener, HttpPostRequestUtils.HttpPostRequestCallback {

    public HomeFragment() {
        // Required empty public constructor
    }

    private GridView header_gridview;//分类列表

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private MyListView homelistview;
    private View headerview;
    private HomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        headerview = inflater.inflate(R.layout.home_header_layout, null, false);
        initHeaderView();
        homelistview = (MyListView) view.findViewById(R.id.homelistview);
        homelistview.setbottom(DensityUtil.dip2px(15));
        homelistview.addHeaderView(headerview);

        getSkilllist();
        return view;
    }

    private void initHeaderView() {
        ViewPager header_viewpager = (ViewPager) headerview.findViewById(R.id.header_viewpager);
        header_viewpager.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenHeight(getActivity()) / 4));
        ImageView[] imageViews = new ImageView[1];
        imageViews[0] = new ImageView(getActivity());
        imageViews[0].setImageResource(R.mipmap.home_03);
        header_viewpager.setAdapter(new SectionsPagerAdapter(getActivity(),imageViews));
        header_gridview = (GridView) headerview.findViewById(R.id.header_gridview);

        header_gridview.setOnItemClickListener(this);
        getHomecategory();
    }

    private static String METHOD_CATEGORY = "category"; // 首页分类
    private static String METHOD_SERVER_LIST = "get_server_list";//首页技能列表（服务列表）

    public void getHomecategory(){
        HashMap<String, String> map  = new HashMap<String, String>();
        map.put("act", METHOD_CATEGORY);
        HttpPostRequestUtils.getInstance(this).Post(map);
    }

    public void getSkilllist() {
        HashMap<String, String> map  = new HashMap<String, String>();
        map.put("act", METHOD_SERVER_LIST);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getActivity(), AtWillBuyActivity.class));
        switch (view.getId()){
            case R.id.header_gridview:
                break;
        }
    }

    private List<Skill> skill_list;
    private List<HomeCategory> homecategor;

    @Override
    public void Success(String method, JSONObject json) throws JSONException {
        if (METHOD_CATEGORY.equals(method)){
            homecategor = JSON.parseArray(json.getString("data"), HomeCategory.class);
            header_gridview.setAdapter(new HeaderGridViewAdapter(getActivity(), homecategor));
        }
        if (METHOD_SERVER_LIST.equals(method)){
            skill_list = JSON.parseArray(json.getString("data"), Skill.class);
            homeAdapter = new HomeAdapter(getActivity(), skill_list);
            homelistview.setAdapter(homeAdapter);
        }
    }

    @Override
    public void Fail(String method, String error) {
        if (x.isDebug()) Toast.makeText(getActivity(), this.getClass().getName() + ": " + method + " error: " + error, Toast.LENGTH_SHORT).show();
    }

}
