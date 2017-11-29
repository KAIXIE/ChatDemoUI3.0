package com.hyphenate.chatuidemo.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.hyphenate.chatuidemo.base.BaseView;


/**
 *
 * @文件名: BasePresenter
 * @创建者:  KaneLiu
 * @创建时间: 2017/7/27 0007 14:50
 * @描述：
 */
public interface BasePresenter {

    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();



}
