package com.chao.mobileplayer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.chao.mobileplayer.R;
import com.chao.mobileplayer.base.BaseFragment;
import com.chao.mobileplayer.pager.AudioFragment;
import com.chao.mobileplayer.pager.NetAudioFragment;
import com.chao.mobileplayer.pager.NetVideoFragment;
import com.chao.mobileplayer.pager.VideoFragment;


import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private FrameLayout frameLayout;
    private RadioGroup rgMain;

    private ArrayList<BaseFragment> fragments;
    private int position;
    private BaseFragment mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fl_main_content);
        rgMain =  findViewById(R.id.rg_bottom_tag);

        //主界面的初始化
        initFragment();
        //主界面的切换监听
        initListener();
    }
    /**
     * 将页面添加到ArrayList数组中
     */
    public void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new VideoFragment());//添加本地视频页面-0
        fragments.add(new AudioFragment());//添加本地音乐页面-1
        fragments.add(new NetVideoFragment());//添加网络视频页面-2
        fragments.add(new NetAudioFragment());//添加网络音频页面-3
    }
    /**
     * 根据按钮选择对应主界面
     */
    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_video:
                        position = 0;  //本地视频
                        break;
                    case R.id.rb_audio:
                        position = 1;  //本地音频
                        break;
                    case R.id.rb_net_video:
                        position = 2;   //网络视频
                        break;
                    case R.id.rb_netaudio:
                        position = 3;   //网络音频
                        break;
                    default:
                        position = 0;
                        break;
                }
                //根据不同位置取不同的fragment
                BaseFragment baseFragment = getFragment(position);
                switchFragment(mContext, baseFragment);
            }
        });
        rgMain.check(R.id.rb_video);
    }
    /**
     * 得到所选界面的位置
     *
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }
    /**
     * 页面切换
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.fl_main_content, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }




}
