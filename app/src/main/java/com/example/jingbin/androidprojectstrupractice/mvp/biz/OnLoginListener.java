package com.example.jingbin.androidprojectstrupractice.mvp.biz;

import com.example.jingbin.androidprojectstrupractice.mvp.bean.User;

/**
 * Created by jingbin on 2016/11/3.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
