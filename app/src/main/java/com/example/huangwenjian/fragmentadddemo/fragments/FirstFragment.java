package com.example.huangwenjian.fragmentadddemo.fragments;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.huangwenjian.fragmentadddemo.R;
import com.example.huangwenjian.fragmentadddemo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: huangwenjian
 * -
 * 描述:
 * -
 * 日期: 16/8/22
 */
public class FirstFragment extends BaseFragment {
    public static final String TAG = "FirstFragment";

    @BindView(R.id.btn_first_click1)
    Button mBtn_first_click1;

    @BindView(R.id.btn_first_click2)
    Button mBtn_first_click2;

    @BindView(R.id.btn_first_click3)
    Button mBtn_first_click3;

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initAfterActivityCreated() {

    }

    @OnClick(R.id.btn_first_click1)
    public void click1() {
        Message message = new Message();
        message.what = 1;
        message.obj = "firstfragment_点了1";
        mUIHandler.sendMessage(message);
    }

    @OnClick(R.id.btn_first_click2)
    public void click2() {
        Message message = new Message();
        message.what = 2;
        message.obj = "firstfragment_点了2";
        mUIHandler.sendMessage(message);
    }

    @Override
    protected void processMsg(Message message) {
        switch (message.what) {
            case 1:
                System.out.println(message.obj);
                break;
            case 2:
                System.out.println(message.obj);
                break;
            case 3:

                break;
            default:
                break;
        }
    }
}
