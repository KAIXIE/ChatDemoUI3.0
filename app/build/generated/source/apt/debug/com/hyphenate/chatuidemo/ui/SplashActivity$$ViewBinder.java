// Generated code from Butter Knife. Do not modify!
package com.hyphenate.chatuidemo.ui;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SplashActivity$$ViewBinder<T extends SplashActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131689653, "field 'mIvSplash' and method 'onViewClicked'");
    target.mIvSplash = finder.castView(view, 2131689653, "field 'mIvSplash'");
    unbinder.view2131689653 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131689654, "field 'mIvSplashLogin' and method 'onViewClicked'");
    target.mIvSplashLogin = finder.castView(view, 2131689654, "field 'mIvSplashLogin'");
    unbinder.view2131689654 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131689655, "field 'mIvSplashRegist' and method 'onViewClicked'");
    target.mIvSplashRegist = finder.castView(view, 2131689655, "field 'mIvSplashRegist'");
    unbinder.view2131689655 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends SplashActivity> implements Unbinder {
    private T target;

    View view2131689653;

    View view2131689654;

    View view2131689655;

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
      view2131689653.setOnClickListener(null);
      target.mIvSplash = null;
      view2131689654.setOnClickListener(null);
      target.mIvSplashLogin = null;
      view2131689655.setOnClickListener(null);
      target.mIvSplashRegist = null;
    }
  }
}
