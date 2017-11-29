// Generated code from Butter Knife. Do not modify!
package com.hyphenate.chatuidemo.mvp.view.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class BlackFragment$$ViewBinder<T extends BlackFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131689989, "field 'mRecyclerBlack'");
    target.mRecyclerBlack = finder.castView(view, 2131689989, "field 'mRecyclerBlack'");
    view = finder.findRequiredView(source, 2131689988, "field 'mRefreshLayout'");
    target.mRefreshLayout = finder.castView(view, 2131689988, "field 'mRefreshLayout'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends BlackFragment> implements Unbinder {
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
      target.mRecyclerBlack = null;
      target.mRefreshLayout = null;
    }
  }
}
