package com.hyphenate.chatuidemo.mvp.presenter.impl;

import android.util.Log;

import com.hyphenate.chatuidemo.mvp.model.BlackModel;
import com.hyphenate.chatuidemo.mvp.presenter.BlackFragmentPresenter;
import com.hyphenate.chatuidemo.mvp.presenter.base.BasePresenterImpl;
import com.hyphenate.chatuidemo.mvp.view.BlackFragmentView;
import com.hyphenate.chatuidemo.network.RetrofitManager;
import com.hyphenate.chatuidemo.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/11/23.
 */

public class BlackFragmentPresenterImpl extends BasePresenterImpl<BlackFragmentView> implements BlackFragmentPresenter {

    @Override
    public void getData(String page, String rows, String articleType) {
        Map<String,String> params = new HashMap<>();
        params.put("page",page);
        params.put("rows",rows);
        params.put("articleType",articleType);
        RetrofitManager.getInstance().blackList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BlackModel>() {
                    @Override
                    public void onCompleted() {
                        Log.e("ccc","请求完毕");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ccc",e.getMessage());
                    }

                    @Override
                    public void onNext(BlackModel blackModel) {

                        if (blackModel.getStatus().equals("1")){
                            LogUtil.e("请求成功");
                            mView.setData(blackModel);
                        }

                    }
                });
    }
}
