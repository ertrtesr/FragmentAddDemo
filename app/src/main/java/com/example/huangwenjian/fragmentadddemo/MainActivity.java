package com.example.huangwenjian.fragmentadddemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.huangwenjian.fragmentadddemo.factory.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {
    @BindView(R.id.btn1)
    Button mBtn1;

    @BindView(R.id.btn2)
    Button mBtn2;

    @BindView(R.id.btn3)
    Button mBtn3;

    @BindView(R.id.fl)
    FrameLayout mFl;

    private Fragment mFirstFragment;
    private Fragment mSecondFragment;
    private Fragment mThirdFragment;
    private FragmentManager mFm;
    private Fragment mCurrentFragment;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mFm = getSupportFragmentManager();                      //得到fragment管理器
        mFirstFragment = FragmentFactory.getFragment(0);        //通过fragment工厂创建fragment
        mSecondFragment = FragmentFactory.getFragment(1);
        mThirdFragment = FragmentFactory.getFragment(2);

        addFragment(mFirstFragment);                            //初始化的时候先添加第一个fragment
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                switchFragment(mFirstFragment);             //切换fragment
                break;
            case R.id.btn2:
                switchFragment(mSecondFragment);
                break;
            case R.id.btn3:
                switchFragment(mThirdFragment);
                break;
            default:
                break;
        }
    }

    /**
     * 切换fragment的方法
     *
     * @param to 需要切换的fragment
     */
    public void switchFragment(Fragment to) {
        if (mCurrentFragment != to) {
            if (!to.isAdded()) {                        //判断fragment是否有add过
                addFragment(to);                        //没有add过就add一下
            }
            FragmentTransaction ft = mFm.beginTransaction();
            for (Fragment fragment : mFragments) {
                ft = ft.hide(fragment);                 //遍历集合,先隐藏所有的fragment
            }
            ft.show(to).commit();                       //展示对应的fragment并提交,注意commit后事务就不可以再复用了
            mCurrentFragment = to;                      //置为当前的fragment
        }
    }

    /**
     * 添加fragment的方法
     *
     * @param fragment 要添加的fragment
     */
    public void addFragment(Fragment fragment) {
        if (!fragment.isAdded()) {
            mFm.beginTransaction().add(R.id.fl, fragment, fragment.getClass().getCanonicalName()).commit();
            mFragments.add(fragment);                   //将fragment加入集合,到时用于遍历集合
        }
    }

    @Override
    public void onBackPressed() {
        System.out.println(mCurrentFragment);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFragments.clear();
    }
}
