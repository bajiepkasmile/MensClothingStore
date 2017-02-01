package com.nodomain.mensclothingstore.utils;


import android.content.Context;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.domain.exceptions.ConnectionFailedException;
import com.nodomain.mensclothingstore.domain.exceptions.NetworkIsNotAvailableException;


public class ErrorUtil {

    private Context context;

    public ErrorUtil(Context context) {
        this.context = context;
    }

    public String exceptionToErrorMessage(Exception e) {
        if (e instanceof NetworkIsNotAvailableException)
            return context.getString(R.string.error_network_is_not_available);
        else if (e instanceof ConnectionFailedException)
            return context.getString(R.string.error_connection_failed);
        else
            return null;
    }
}
