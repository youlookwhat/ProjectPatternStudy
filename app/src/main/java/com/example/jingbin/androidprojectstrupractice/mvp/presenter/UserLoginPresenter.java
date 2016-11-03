package com.example.jingbin.androidprojectstrupractice.mvp.presenter;

import android.os.Handler;

import com.example.jingbin.androidprojectstrupractice.mvp.bean.User;
import com.example.jingbin.androidprojectstrupractice.mvp.biz.OnLoginListener;
import com.example.jingbin.androidprojectstrupractice.mvp.biz.UserBiz;
import com.example.jingbin.androidprojectstrupractice.mvp.view.IUserLoginView;


/**
 * Created by jingbin on 2016/11/3.
 * Presenter是用作Model和View之间交互的桥梁，那么应该有什么方法呢？
 * 其实也是主要看该功能有什么操作，比如本例，两个操作:login和clear。
 */

public class UserLoginPresenter {

    private IUserLoginView iUserLoginView;
    private UserBiz userBiz;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        iUserLoginView.showLoading();
        userBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
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
