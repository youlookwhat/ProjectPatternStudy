package com.example.jingbin.projectstru.mvpdatabindind;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jingbin.projectstru.R;
import com.example.jingbin.projectstru.databinding.ActivityMvpDataBindingBinding;
import com.example.jingbin.projectstru.mvpdatabindind.Presenter.ChangeAgePresenter;
import com.example.jingbin.projectstru.mvvm.bean.User;

/**
 * MVP + data-binding
 * Bean是mvvm里的bean:   User
 * Model是mvvm里的model
 */
public class MvpDataBindingActivity extends AppCompatActivity {

    private ActivityMvpDataBindingBinding viewDataBinding;
    private User myUser;
    private ChangeAgePresenter changeAgePresenter = new ChangeAgePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_data_binding);

        setTitle("MVP + data-binding");

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvp_data_binding);
        myUser = new User("年龄", 23);
        viewDataBinding.setUser(myUser);
        viewDataBinding.setButtonname("年龄+2");

        /**
         * 将点击时间直接写在了布局文件里
         */
//        viewDataBinding.btAge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeAgePresenter.changeAge(myUser);
//            }
//        });
    }
}
