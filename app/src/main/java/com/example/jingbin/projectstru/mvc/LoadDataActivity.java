package com.example.jingbin.projectstru.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingbin.projectstru.R;
import com.example.jingbin.projectstru.mvc.bean.Essay;
import com.example.jingbin.projectstru.mvc.model.EssayModel;
import com.example.jingbin.projectstru.mvc.model.MainModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MVC：
 * View：对应于布局文件
 * Model：业务逻辑和实体模型
 * Controllor：对应于Activity
 * 看起来的确像那么回事，但是细细的想想这个View对应于布局文件，其实能做的事情特别少，
 * 实际上关于该布局文件中的数据绑定的操作，事件处理的代码都在Activity中，
 * 造成了Activity既像View又像Controller（当然了Data-Binder的出现，可能会让View更像View吧）。
 * 这可能也就是为何，在该文中有一句这样的话：
 * Most of the modern Android applications just use View-Model architecture，everything is connected with Activity.
 */
public class LoadDataActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_mvc)
    Button btnMvc;
    @BindView(R.id.tv_view)
    TextView tvView;
    @BindView(R.id.btn_mvc2)
    Button btnMvc2;
    @BindView(R.id.tv_view_updata)
    TextView tvViewUpdata;
    @BindView(R.id.activity_load_data)
    LinearLayout activityLoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);
        ButterKnife.bind(this);
        setTitle("MVC");

        btnMvc.setOnClickListener(this);
        btnMvc2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mvc:// MVC加载数据
                MainModel mainModel = new MainModel();
                mainModel.load(new MainModel.MainImpl() {
                    @Override
                    public void success(String text) {
                        tvView.setText("MVC加载数据: " + text);
                    }
                });
                break;

            case R.id.btn_mvc2:// MVC更新数据(更合理)
                /**
                 * 将业务逻辑封装在Model里, 但C(Activity)层可以和Model直接交互, 交互完后根据显示结果来调整V层(如 显示数据)
                 */
                EssayModel essayModel = new EssayModel(LoadDataActivity.this);
                essayModel.getEssay(3, new EssayModel.OnEssayListener() {
                    @Override
                    public void onSuccess(List<Essay> list) {
                        /**
                         * 直接使用list,得到List的逻辑都放在mode层
                         */
                        if (list != null && list.get(0) != null) {
                            tvViewUpdata.setText("MVC 更新数据: " + list.get(0).getTitle());
                        }
                    }

                    @Override
                    public void onError() {

                    }
                });
                break;
            default:
                break;
        }
    }
}