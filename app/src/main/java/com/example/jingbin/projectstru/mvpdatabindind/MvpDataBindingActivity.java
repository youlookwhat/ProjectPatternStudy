package com.example.jingbin.projectstru.mvpdatabindind;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jingbin.projectstru.R;
import com.example.jingbin.projectstru.databinding.ActivityMvpDataBindingBinding;
import com.example.jingbin.projectstru.mvpdatabindind.presenter.ChangeAgePresenter;
import com.example.jingbin.projectstru.mvpdatabindind.bean.UserBean;
import com.example.jingbin.projectstru.mvpdatabindind.view.ChangeAgeView;

/**
 * MVP + data-binding
 *
 * @author jingbin
 */
public class MvpDataBindingActivity extends AppCompatActivity implements ChangeAgeView {

    private ActivityMvpDataBindingBinding binding;
    private ChangeAgePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvp_data_binding);

        setTitle("MVP + data-binding");
        presenter = new ChangeAgePresenter(this);
        binding.setButtonname("年龄+2");

        binding.btAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.changeAge(binding.getUser());
            }
        });
    }

    @Override
    public void showContentView(UserBean user) {
        binding.setUser(user);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clear();
    }
}
