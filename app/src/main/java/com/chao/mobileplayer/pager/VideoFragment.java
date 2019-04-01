package com.chao.mobileplayer.pager;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chao.mobileplayer.base.BaseFragment;
import com.chao.mobileplayer.utils.LogUtil;

/*
 *author:SunChao
 *function:本地视频页面
 */
public class VideoFragment extends BaseFragment {
    private static final String TAG = VideoFragment.class.getSimpleName();
    private TextView textView;

    @Override
    public View initView() {
        LogUtil.e("本地视频页面被初始化了");
        textView=new TextView(mContext);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }
    public void initData(){
        super.initData();
        LogUtil.e("本地视频页面的数据被初始化了");
        textView.setText("本地视频页面");

    }
}
