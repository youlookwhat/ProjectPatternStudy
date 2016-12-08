package com.example.jingbin.projectstru.mvc.model;

/**
 * Created by jingbin on 2016/11/4.
 */

public class MainModel {

    private MainImpl mMain;

    public interface MainImpl {
        void success(String text);
    }

    public void load(MainImpl main) {
        this.mMain = main;
        // 一系列处理后得到text
        String text = "MVC模式在Android中的应用，获取到的Model中处理的数据";
        main.success(text);
    }
}
