package com.hyphenate.chatuidemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * 可点击 Drawable EditText
 * 自带清空按钮的EditText
 * Created by Boyce on 2016/3/17.
 */
@SuppressLint("AppCompatCustomView")
public class XEditText extends EditText {
    private DrawableLeftListener mLeftListener;
    private DrawableRightListener mRightListener;

    final int DRAWABLE_LEFT = 0;
    final int DRAWABLE_TOP = 1;
    final int DRAWABLE_RIGHT = 2;
    final int DRAWABLE_BOTTOM = 3;

    private boolean drawableEnable = true;
    private Drawable drawableRight,drawableLeft,drawableTop,drawableBottom;
    private Rect rBounds;
    public XEditText(Context context) {
        super(context);
        init();
    }

    public XEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void setDrawableLeftListener(DrawableLeftListener listener) {
        this.mLeftListener = listener;
    }
    private void init(){
        setEditTextDrawable();
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setEditTextDrawable();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void setDrawableEnable(boolean enable){
        this.drawableEnable = enable;
    }
    private void setEditTextDrawable(){
        if (drawableEnable){
            if (getText().toString().length() == 0) {
                setCompoundDrawables(this.drawableLeft, this.drawableTop, null, this.drawableBottom);
            } else {
                setCompoundDrawables(this.drawableLeft, this.drawableTop, this.drawableRight, this.drawableBottom);
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.drawableRight = null;
        this.rBounds = null;
    }

    @Override
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (right != null) this.drawableRight = right;
        if (left != null) this.drawableLeft = left;
        if (top != null) this.drawableTop = top;
        if (bottom != null) this.drawableBottom = bottom;
        super.setCompoundDrawables(left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if ((this.drawableRight != null) && (event.getAction() == MotionEvent.ACTION_UP)) {
            this.rBounds = this.drawableRight.getBounds();
            int i = (int) event.getRawX();// 距离屏幕的距离
            // int i = (int) paramMotionEvent.getX();//距离边框的距离
            if (i > getRight() - 3 * this.rBounds.width()) {
                setText("");
                event.setAction(MotionEvent.ACTION_CANCEL);
            }
        }
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_UP:
//                if (mRightListener != null) {
//                    Drawable drawableRight = getCompoundDrawables()[DRAWABLE_RIGHT];
//                    if (drawableRight != null && event.getRawX() >= (getRight() - drawableRight.getBounds().width())) {
//                        mRightListener.onDrawableRightClick(this);
//                        return true;
//                    }
//                }
//                if (mLeftListener != null) {
//                    Drawable drawableLift = getCompoundDrawables()[DRAWABLE_RIGHT];
//                    if (drawableLift != null && event.getRawX() >= (getLeft() + drawableLift.getBounds().width()))
//                        mLeftListener.onDrawableLeftClick(this);
//                }
//                break;
//        }
        return super.onTouchEvent(event);
    }
    public void setDrawableRightListener(DrawableRightListener listener) {
        this.mRightListener = listener;
    }
    public interface DrawableLeftListener {
        void onDrawableLeftClick(View view);
    }

    public interface DrawableRightListener {
        void onDrawableRightClick(View view);
    }
}
