package com.example.everyoneassist.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.everyoneassist.R;
import com.example.everyoneassist.Utils.Constant;

public class BaseActivity extends AppCompatActivity {

    protected FrameLayout right;
    protected TextView right_text, title;
    protected ImageView right_img, left;

    protected void initHeader(String titles){
        left = (ImageView) this.findViewById(R.id.left);
        title = (TextView) this.findViewById(R.id.title);
        title.setText(titles);
        right = (FrameLayout) this.findViewById(R.id.right);
        right_text = (TextView) this.findViewById(R.id.right_text);
        right_img = (ImageView) this.findViewById(R.id.right_img);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void setRightText(String rights){
        right.setVisibility(View.VISIBLE);
        right_img.setVisibility(View.GONE);
        right_text.setText(rights);
    }

    protected void setRightImg(int res){
        right.setVisibility(View.VISIBLE);
        right_text.setVisibility(View.GONE);
        right_img.setImageResource(res);
    }

    protected SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        shared = getSharedPreferences(Constant.SHARED_NAME, MODE_PRIVATE);

    }
}
