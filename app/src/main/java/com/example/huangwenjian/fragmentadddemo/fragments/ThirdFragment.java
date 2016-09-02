package com.example.huangwenjian.fragmentadddemo.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huangwenjian.fragmentadddemo.R;
import com.example.huangwenjian.fragmentadddemo.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * 作者: huangwenjian
 * -
 * 描述:
 * -
 * 日期: 16/8/22
 */
public class ThirdFragment extends BaseFragment {
    public static final String TAG = "ThirdFragment";

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initAfterActivityCreated() {

    }
}
