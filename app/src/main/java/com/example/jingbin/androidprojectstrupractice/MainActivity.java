package com.example.jingbin.androidprojectstrupractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jingbin.androidprojectstrupractice.mvc.LoadDataActivity;
import com.example.jingbin.androidprojectstrupractice.mvp.UserLoginActivity;
import com.example.jingbin.androidprojectstrupractice.mvvm.ChangeAgeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_mvp)
    Button btMvp;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.bt_mvc)
    Button btMvc;
    @BindView(R.id.bt_mvvm_data_binding)
    Button btMvvmDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btMvc.setOnClickListener(this);
        btMvp.setOnClickListener(this);
        btMvvmDataBinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_mvc:// MVC 以更新数据为例
                startActivity(new Intent(MainActivity.this, LoadDataActivity.class));
                break;
            case R.id.bt_mvp:// MVP 以用户登录为例
                startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
                break;
            case R.id.bt_mvvm_data_binding:// MVVM + data-binding 以点击一下按钮然后年龄会+2 为例
                startActivity(new Intent(MainActivity.this, ChangeAgeActivity.class));
                break;
            default:
                break;
        }
    }
}
