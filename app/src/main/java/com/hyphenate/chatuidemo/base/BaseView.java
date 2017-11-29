package com.hyphenate.chatuidemo.base;

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showMsg(String message);

    void showError(String message);
}
