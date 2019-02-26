package com.example.jingbin.projectstru.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * @author jingbin
 */
public class ChangeAgeViewModel extends AndroidViewModel {

    final MutableLiveData<String> desc = new MutableLiveData<>();
    public final ObservableField<String> age = new ObservableField<>();

    public ChangeAgeViewModel(@NonNull Application application) {
        super(application);
        age.set(String.valueOf(23));

        desc.setValue("年龄");
    }

    void change() {
        String value = age.get();
        if (!TextUtils.isEmpty(value)) {
            Integer integer = Integer.valueOf(value);
            // 改变age的值 布局里的值直接改变
            age.set(String.valueOf(integer + 2));

            desc.setValue("年龄改变:" + age.get());
        }
    }

}
