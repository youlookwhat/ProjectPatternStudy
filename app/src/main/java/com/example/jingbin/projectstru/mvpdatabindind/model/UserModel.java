package com.example.jingbin.projectstru.mvpdatabindind;


/**
 * Created by jingbin on 2016/11/6.
 */

public class UserModel {


    public interface Change {
        void success(UserBean user);
    }

    /**
     * User 没有继承BaseObservable时
     */
    public void changeAge(UserBean user, int add, Change change) {
        // 一系列操作
        user.age = user.age + add;
        change.success(user);
    }

    /**
     * 继承后直接更新UI
     */
    public void changeEssay(UserBean user, int add) {
        user.setAge(user.age + add);
    }
}
