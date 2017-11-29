package com.hyphenate.chatuidemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @项目名： MiFengJi
 * @包名： cn.mifengji.app.base
 * @文件名: BaseLazyFragment
 * @创建者: 刘勇
 * @创建时间: 2016/09/24  12:01
 * @描述： TODO
 */


public abstract class BaseLazyFragment extends Fragment {

    // Fragment当前状态是否可见
    protected boolean isVisible;
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = View.inflate(getContext(),getLayoutID(),null);
        unbinder = ButterKnife.bind(this,layout);
        initFragment();
        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * @创建时间: 2016-9-23  12:28
     * @描述： 加载布局XML布局ID
     */
    protected int getLayoutID() {
        return 0;
    }

    /**
     *  @创建时间:  2016-9-23  12:29
     *  @描述：    在这里做fragment的初始化工作
     */
    protected abstract void initFragment();

    /**
     *  @创建时间:  2016-9-23  12:29
     *  @描述：    在这里进行视图操作
     */
    protected void initView() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    /**
     *  @创建时间:  2016-9-23  12:30
     *  @描述：    fragment状态可见
     */
    protected void onVisible() {
        lazyLoad();
    }


    /**
     *  @创建时间:  2016-9-23  12:31
     *  @描述：    fragment状态不可见
     */
    protected void onInvisible() {


    }


    /**
     *  @创建时间:  2016-9-23  12:30
     *  @描述：    实现懒加载须重写此方法
     */
    protected  void lazyLoad(){

    }


    /**
     *  @创建时间:  2016-9-23  12:31
     *  @描述：    吐司方法
     *  @param message 消息
     */
    public void showToast(String message){
        Toast.makeText(getContext(),message, Toast.LENGTH_SHORT).show();
    }

    /**
     *  @创建时间:  2016-9-23  12:31
     *  @描述：    页面跳转
     *  @param cls 要跳转的activity.class
     */
    public void goTo(Class cls){
        startActivity(new Intent(getContext(),cls));
    }
}
