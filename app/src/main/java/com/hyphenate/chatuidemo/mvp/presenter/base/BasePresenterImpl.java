package com.hyphenate.chatuidemo.mvp.presenter.base;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.hyphenate.chatuidemo.base.BaseView;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 *
 * @文件名: BasePresenterImpl
 * @创建者:  KaneLiu
 * @创建时间: 2017/7/27 0007 15:50
 * @描述：
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter {
    protected T mView;

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (T) view;
    }

}
