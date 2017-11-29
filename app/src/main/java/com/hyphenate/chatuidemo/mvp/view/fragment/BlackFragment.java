package com.hyphenate.chatuidemo.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.hyphenate.chatuidemo.R;
import com.hyphenate.chatuidemo.base.BaseLazyFragment;
import com.hyphenate.chatuidemo.mvp.model.BlackModel;
import com.hyphenate.chatuidemo.mvp.presenter.BlackFragmentPresenter;
import com.hyphenate.chatuidemo.mvp.presenter.impl.BlackFragmentPresenterImpl;
import com.hyphenate.chatuidemo.mvp.view.BlackFragmentView;
import com.hyphenate.chatuidemo.ui.my.MyAdapter;
import com.hyphenate.chatuidemo.utils.LogUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/23.
 */

public class BlackFragment extends BaseLazyFragment implements BlackFragmentView {
//    private List<String> mlist = new ArrayList<>();
//    private List<BlackModel.ArticlePagerBean.RowsBean> mList = new ArrayList<>();
    private BlackModel mBlackModel;
    @BindView(R.id.recycler_black)
    RecyclerView mRecyclerBlack;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;
    private MyAdapter myAdapter;
    private BlackFragmentPresenter mBlackFragmentPresenter;
    private List<BlackModel.ArticlePagerBean.RowsBean> mRowsBeanList;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_black;
    }

    @Override
    protected void initFragment() {
        mBlackFragmentPresenter = new BlackFragmentPresenterImpl();
        mBlackFragmentPresenter.attachView(this);
       mBlackFragmentPresenter.getData("1","10","1");
        //假数据
        initData();
        mRecyclerBlack.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        blackRecyclerAdapter = new BlackDetailPhotoAdapter(getContext(),mlist);
//        recyclerBlack.setAdapter(blackRecyclerAdapter);
//        blackRecyclerAdapter.notifyDataSetChanged();
        myAdapter = new MyAdapter(mRowsBeanList, getContext());
        mRecyclerBlack.setAdapter(myAdapter);
        myAdapter.addHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.item_black_head, null));

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                //假数据
                initData();
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });

    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
//            mlist.add("" + i);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void setData(BlackModel blackModel) {
        mBlackModel = blackModel;
        mRowsBeanList = mBlackModel.getArticlePager().getRows();
        LogUtil.e("---"+ mRowsBeanList.size());
        LogUtil.e("---"+ mRowsBeanList.get(0));
    }
}
