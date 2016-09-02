package com.example.huangwenjian.fragmentadddemo.handler;

import android.os.Handler;
import android.os.Message;

/**
 * 作者: huangwenjian
 * <p/>
 * 描述:
 * <p/>
 * 时间: 16/9/2
 */
public class UIHandler extends Handler {
    private IHandler mIHandler;

    public UIHandler() {

    }

    public UIHandler(IHandler ihandler) {
        this.mIHandler = ihandler;
    }

    public void setHandler(IHandler ihandler) {
        this.mIHandler = ihandler;
    }

    /**
     * UIHandler发消息sendmessage以后都会由这个方法接收,然后回调给IHandler对象,由IHandler的handelMessage方法来处理消息
     * @param message
     */
    @Override
    public void handleMessage(Message message) {
        super.handleMessage(message);

        if (mIHandler != null) {
            mIHandler.handleMessage(message);           //该句代码执行后会回调至setHandler的位置
        }
    }
}
