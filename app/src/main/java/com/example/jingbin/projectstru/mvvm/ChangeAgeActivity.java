package com.example.jingbin.projectstru.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jingbin.projectstru.R;
import com.example.jingbin.projectstru.databinding.ActivityChangeAgeBinding;
import com.example.jingbin.projectstru.mvvm.bean.User;
import com.example.jingbin.projectstru.mvvm.model.UserModel;

/**
 * 简单的MVVM + data-binding案例:
 * 以点击一下按钮然后年龄会+2 为例
 * <p>
 * 与MVC 很像,也会造成Activity里代码冗余的情况,建议MVP + data-binding
 */
public class ChangeAgeActivity extends AppCompatActivity {

    private User myUser;
    private ActivityChangeAgeBinding viewDataBinding;
    //    private ViewDataBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MVVM + data-binding");

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_change_age);
        myUser = new User("年龄", 23);
        viewDataBinding.setUser(myUser);
        viewDataBinding.setButtonname("年龄+2");

        viewDataBinding.btAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * User 没有继承BaseObservable时
                 */
//                UserModel userModel = new UserModel();
//                userModel.changeAge(myUser, 2, new UserModel.Chage() {
//                    @Override
//                    public void success(User user) {
//                        viewDataBinding.setUser(user);
//                    }
//                });

                /**
                 * User 继承BaseObservable后,实现自动同步,无需
                 * viewDataBinding.setUser(user);
                 */
                UserModel userModel1 = new UserModel();
                userModel1.changeEssay(myUser, 2);

            }
        });

    }
}
