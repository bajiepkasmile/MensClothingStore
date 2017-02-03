package com.nodomain.mensclothingstore.utils;


import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;


public class ToastUtil {

    private Context context;

    @Inject
    public ToastUtil(Context context) {
        this.context = context;
    }

    public Toast createCenteredToast(String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);

        LinearLayout layout = (LinearLayout) toast.getView();
        if (layout.getChildCount() > 0) {
            TextView tv = (TextView) layout.getChildAt(0);
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }

        return toast;
    }
}
