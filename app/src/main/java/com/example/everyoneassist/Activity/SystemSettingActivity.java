package com.example.everyoneassist.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.everyoneassist.R;

public class SystemSettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_setting);
        initHeader("系统设置");


        initView();
    }

    private TextView addr_manager, update_version, about;

    private void initView() {
        addr_manager = (TextView) this.findViewById(R.id.addr_manager);
        update_version = (TextView) this.findViewById(R.id.update_version);
        about = (TextView) this.findViewById(R.id.about);
        addr_manager.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addr_manager:
                startActivity(new Intent(this, AddressManagerActivity.class));
                break;
        }
    }
}
