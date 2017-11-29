// Generated code from Butter Knife. Do not modify!
package com.hyphenate.chatuidemo.ui.my;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MyAdapter$MyHolder$$ViewBinder<T extends MyAdapter.MyHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131689715, "field 'mIvIcon'");
    target.mIvIcon = finder.castView(view, 2131689715, "field 'mIvIcon'");
    view = finder.findRequiredView(source, 2131689678, "field 'mTvName'");
    target.mTvName = finder.castView(view, 2131689678, "field 'mTvName'");
    view = finder.findRequiredView(source, 2131689982, "field 'mTvTime'");
    target.mTvTime = finder.castView(view, 2131689982, "field 'mTvTime'");
    view = finder.findRequiredView(source, 2131689983, "field 'mIvPhoto'");
    target.mIvPhoto = finder.castView(view, 2131689983, "field 'mIvPhoto'");
    view = finder.findRequiredView(source, 2131689984, "field 'mTvDes'");
    target.mTvDes = finder.castView(view, 2131689984, "field 'mTvDes'");
    view = finder.findRequiredView(source, 2131689985, "field 'mTvNumLook'");
    target.mTvNumLook = finder.castView(view, 2131689985, "field 'mTvNumLook'");
    view = finder.findRequiredView(source, 2131689986, "field 'mTvNumZan'");
    target.mTvNumZan = finder.castView(view, 2131689986, "field 'mTvNumZan'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MyAdapter.MyHolder> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.mIvIcon = null;
      target.mTvName = null;
      target.mTvTime = null;
      target.mIvPhoto = null;
      target.mTvDes = null;
      target.mTvNumLook = null;
      target.mTvNumZan = null;
    }
  }
}
