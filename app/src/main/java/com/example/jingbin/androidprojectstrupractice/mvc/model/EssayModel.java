package com.example.jingbin.androidprojectstrupractice.mvc.model;

import android.content.Context;

import com.example.jingbin.androidprojectstrupractice.mvc.bean.Essay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingbin on 2016/11/3.
 * 松耦合需要我们通过model来将数据分离，将网络，数据库和数据的获得将其封装.
 * <p>
 * 这也可以复用,这个model可以得到想要的数据
 *
 * Model: 业务逻辑和实体模型
 */

public class EssayModel {

    public interface OnEssayListener {
        void onSuccess(List<Essay> list);

        void onError();
    }

    private Context mContext;

    public EssayModel(Context mContext) {
        this.mContext = mContext;
    }

    private OnEssayListener onEssayListener;

    public void getEssay(int num, OnEssayListener listener) {
        this.onEssayListener = listener;
        ArrayList<Essay> list = new ArrayList<>();
        Essay essay = new Essay();
        if (num != 0) {
            essay.setTitle("更新的title");
        } else {
            essay.setTitle("传入的为0");
        }
        list.add(essay);
        //...
        /**
         * 直接回调出想要的数据,在对应的Activity中不需要知道具体怎么得到的数据,起到了封装的作用
         */
        onEssayListener.onSuccess(list);
    }
}
