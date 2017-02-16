package com.nodomain.mensclothingstore.ui.customviews;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.nodomain.mensclothingstore.ui.listeners.OnScrollPositionChangeListener;


public class ListenableScrollView extends ScrollView {

    private OnScrollPositionChangeListener listener;

    public ListenableScrollView(Context context) {
        super(context);
    }

    public ListenableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListenableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ListenableScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int curHorizontal, int curVertical, int prevHorizontal, int prevVertical) {
        super.onScrollChanged(curHorizontal, curVertical, prevHorizontal, prevVertical);
        if (listener != null) {
            listener.onScrollPositionChange();
        }
    }

    public void setOnScrollPositionChangeListener(OnScrollPositionChangeListener listener) {
        this.listener = listener;
    }
}
