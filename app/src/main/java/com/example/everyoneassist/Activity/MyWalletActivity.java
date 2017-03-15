package com.example.everyoneassist.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.everyoneassist.Adapter.MyWalletUseAdapter;
import com.example.everyoneassist.R;

public class MyWalletActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        initHeader("我的钱包");

        initView();

    }

    private ListView walletuse_list;
    private View headerView;
    private TextView mywallet_deposit, mywallet_withdraw_deposit;

    private void initView() {
        walletuse_list = (ListView) this.findViewById(R.id.walletuse_list);
        headerView = LayoutInflater.from(this).inflate(R.layout.mywallet_header, null, false);

        walletuse_list.addHeaderView(headerView);
        walletuse_list.setAdapter(new MyWalletUseAdapter(this));

        mywallet_deposit = (TextView) headerView.findViewById(R.id.mywallet_deposit);
        mywallet_withdraw_deposit = (TextView) headerView.findViewById(R.id.mywallet_withdraw_deposit);

        mywallet_deposit.setOnClickListener(this);
        mywallet_withdraw_deposit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mywallet_deposit:

                break;
            case R.id.mywallet_withdraw_deposit:

                break;
        }
    }
}
