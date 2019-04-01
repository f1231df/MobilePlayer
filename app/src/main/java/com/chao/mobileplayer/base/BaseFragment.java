package com.chao.mobileplayer.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 *author:SunChao
 *function:****
 */
public abstract class BaseFragment extends Fragment {
    public Context mContext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 有子类实现，实现特有效果
     * 抽象abstract 方法initView ,既没有方法体。所以其类必为抽象类
     * @return
     */
    public abstract View initView();

    /**
     * 初始化数据
     */
    public void initData() {

    }

}
