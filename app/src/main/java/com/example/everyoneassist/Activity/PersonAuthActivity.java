package com.example.everyoneassist.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.everyoneassist.Layout.PercentLinearLayout;
import com.example.everyoneassist.R;

public class PersonAuthActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_auth);
        initHeader("个人认证");

        initView();

    }

    private PercentLinearLayout auth_credit, auth_phone, auth_autonym;

    private void initView() {
        auth_autonym = (PercentLinearLayout) this.findViewById(R.id.auth_autonym);
        auth_credit = (PercentLinearLayout) this.findViewById(R.id.auth_credit);
        auth_phone = (PercentLinearLayout) this.findViewById(R.id.auth_phone);

        auth_autonym.setOnClickListener(this);
        auth_phone.setOnClickListener(this);
        auth_autonym.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.auth_autonym:
                startActivity(new Intent(this, AuthAutonymActivity.class));
                break;
            case R.id.auth_phone:
                startActivity(new Intent(this, AuthPhoneActivity.class));
                break;
        }
    }
}
