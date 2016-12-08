package com.example.jingbin.projectstru.mvp.presenter;

import android.os.Handler;

import com.example.jingbin.projectstru.mvp.bean.User;
import com.example.jingbin.projectstru.mvp.model.OnLoginListener;
import com.example.jingbin.projectstru.mvp.model.UserBiz;
import com.example.jingbin.projectstru.mvp.view.IUserLoginView;


/**
 * Created by jingbin on 2016/11/3.
 * Presenter是用作Model和View之间交互的桥梁，那么应该有什么方法呢？
 * 其实也是主要看该功能有什么操作，比如本例，两个操作:login和clear。
 */

public class UserLoginPresenter {

    // view
    private IUserLoginView iUserLoginView;
    // model
    private UserBiz mUserBiz;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        this.mUserBiz = new UserBiz();
    }

    public void login() {
        //view
        iUserLoginView.showLoading();
        // model
        mUserBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {

                // 需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity();
                        iUserLoginView.hindLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                // 需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.hindLoading();
                        iUserLoginView.showFailedError();
                    }
                });
            }
        });
    }

    public void clear() {
        iUserLoginView.clearUserName();
        iUserLoginView.clearPassword();
    }

}
