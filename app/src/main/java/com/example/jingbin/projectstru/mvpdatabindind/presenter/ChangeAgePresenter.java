package com.example.jingbin.projectstru.mvpdatabindind.presenter;

import com.example.jingbin.projectstru.mvpdatabindind.view.ChangeAgeView;
import com.example.jingbin.projectstru.mvpdatabindind.bean.UserBean;
import com.example.jingbin.projectstru.mvpdatabindind.model.UserModel;

/**
 * @author jingbin
 * @date 2019/02/26
 */

public class ChangeAgePresenter {

    private ChangeAgeView changeInterface;
    private UserModel userModel;

    public ChangeAgePresenter(ChangeAgeView changeInterface) {
        this.changeInterface = changeInterface;
        // 初始化
        changeInterface.showContentView(new UserBean("小白", 23));
    }

    /**
     * 改变年龄
     */
    public void changeAge(UserBean myUser) {
        if (userModel == null) {
            userModel = new UserModel();
        }
        userModel.changeAge(myUser, 2, new UserModel.ChangeInterface() {
            @Override
            public void success(UserBean user) {
                changeInterface.showContentView(user);
            }
        });
    }

    public void clear() {
        userModel = null;
    }
}
