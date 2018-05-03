package com.rjr.mddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/3.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @FragmentType
    private int type;

    public static MyFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt("type");
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_game;
    }

    @Override
    protected void init() {
        switch (type) {
            case FragmentType.TYPE_1:
                tvContent.setText("游戏");
                break;
            case FragmentType.TYPE_2:
                tvContent.setText("返利");
                break;
            case FragmentType.TYPE_3:
                tvContent.setText("我的");
                break;
            case FragmentType.TYPE_4:
                tvContent.setText("礼包");
                break;
        }
    }
}
