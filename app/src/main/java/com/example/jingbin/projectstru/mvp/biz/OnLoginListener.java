package com.example.jingbin.projectstru.mvp.biz;


import com.example.jingbin.projectstru.mvp.bean.User;

/**
 * Created by jingbin on 2016/11/3.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
