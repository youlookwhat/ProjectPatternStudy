package com.example.jingbin.androidprojectstrupractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jingbin.androidprojectstrupractice.mvc.LoadDataActivity;
import com.example.jingbin.androidprojectstrupractice.mvp.UserLoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_mvp)
    Button btMvp;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.bt_mvc)
    Button btMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btMvc.setOnClickListener(this);
        btMvp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_mvc:
                startActivity(new Intent(MainActivity.this, LoadDataActivity.class));
                break;
            case R.id.bt_mvp:
                startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
                break;
            default:
                break;
        }
    }
}
