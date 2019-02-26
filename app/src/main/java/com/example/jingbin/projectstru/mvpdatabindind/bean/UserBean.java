package com.example.jingbin.projectstru.mvpdatabindind;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.jingbin.projectstru.BR;

/**
 * Created by jingbin on 2016/11/6.
 */

public class UserBean extends BaseObservable {

    public String name;
    public int age;

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
        // 更新对应变量
        notifyPropertyChanged(BR.name);
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public int getAge() {
        return age;
    }
}
