package com.nodomain.mensclothingstore.utils;


import android.content.Context;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.domain.Error;

import javax.inject.Inject;


public class ErrorUtil {

    private Context context;

    @Inject
    public ErrorUtil(Context context) {
        this.context = context;
    }

    public String errorToErrorMessage(Error error) {
        switch (error) {
            case NETWORK_IS_NOT_AVAILABLE:
                return context.getString(R.string.error_network_is_not_available);
            case CONNECTION_FAILED:
                return context.getString(R.string.error_connection_failed);
            case EMPTY_FIELD:
                return context.getString(R.string.error_empty_filed);
            default:
                return "";
        }
    }
}
