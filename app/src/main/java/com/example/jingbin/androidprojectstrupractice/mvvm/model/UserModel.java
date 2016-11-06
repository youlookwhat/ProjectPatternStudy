package com.example.jingbin.androidprojectstrupractice.mvvm.model;

import com.example.jingbin.androidprojectstrupractice.mvvm.bean.User;

/**
 * Created by jingbin on 2016/11/6.
 */

public class UserModel {

    private Chage change;

    public interface Chage {
        void success(User user);
    }

    /**
     * User 没有继承BaseObservable时
     */
    public void changeAge(User user, int add, Chage chage) {

        // 一系列操作
        user.age = user.age + add;

        chage.success(user);
    }

    /**
     * 继承后直接更新UI
     */
    public void changeEssay(User user, int add) {
//        user.setAge(user.getAge() + add);
        user.setAge(user.age + add);
    }
}
