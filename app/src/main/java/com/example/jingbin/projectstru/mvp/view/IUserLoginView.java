package com.example.jingbin.projectstru.mvp.view;

/**
 * Created by jingbin on 2016/11/3.
 * 总结下，对于View的接口，去观察功能上的操作，然后考虑：
 * 该操作需要什么？（getUserName, getPassword）
 * 该操作的结果，对应的反馈？(toMainActivity, showFailedError)
 * 该操作过程中对应的友好的交互？(showLoading, hideLoading)
 */

public interface IUserLoginView {

    // login说明了要有用户名、密码，那么对应两个方法：
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    // 再者login是个耗时操作，我们需要给用户一个友好的提示，一般就是操作ProgressBar，所以再两个：
    void showLoading();

    void hindLoading();


    // login当然存在登录成功与失败的处理，我们主要看成功我们是跳转Activity，而失败可能是去给个提醒：
    void toMainActivity();

    void showFailedError();


}
