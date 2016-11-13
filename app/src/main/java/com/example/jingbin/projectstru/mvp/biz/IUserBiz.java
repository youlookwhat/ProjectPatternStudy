package com.example.jingbin.projectstru.mvp.biz;

/**
 * Created by jingbin on 2016/11/3.
 */

public interface IUserBiz {

    public void login(String username, String password, OnLoginListener loginListener);
}
