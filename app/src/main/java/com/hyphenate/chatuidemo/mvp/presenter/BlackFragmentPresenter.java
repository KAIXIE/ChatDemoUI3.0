package com.hyphenate.chatuidemo.mvp.presenter;

import com.hyphenate.chatuidemo.mvp.presenter.base.BasePresenter;

/**
 * Created by Administrator on 2017/11/23.
 */

public interface BlackFragmentPresenter extends BasePresenter{
    void getData(String page,String rows,String articleType);
}
