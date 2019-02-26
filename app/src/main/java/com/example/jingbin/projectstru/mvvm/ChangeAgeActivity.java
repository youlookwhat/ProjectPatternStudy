package com.example.jingbin.projectstru.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.jingbin.projectstru.R;
import com.example.jingbin.projectstru.databinding.ActivityChangeAgeBinding;

/**
 * 简单的MVVM + data-binding案例:
 * 以点击一下按钮然后年龄会+2 为例
 *
 * @author jingbin
 */
public class ChangeAgeActivity extends AppCompatActivity {

    private ChangeAgeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChangeAgeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_change_age);
        setTitle("MVVM + data-binding");

        viewModel = ViewModelProviders.of(this).get(ChangeAgeViewModel.class);
        binding.setViewModel(viewModel);
        binding.setButtonname("年龄+2");

        /**监听年龄的变化*/
        viewModel.desc.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String desc) {
                Log.e("desc", desc);
            }
        });

        binding.btAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.change();
            }
        });

    }
}
