package com.nodomain.mensclothingstore.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nodomain.mensclothingstore.domain.exceptions.NetworkIsNotAvailableException;

import javax.inject.Inject;


public class NetworkUtil {

    private final ConnectivityManager connectivityManager;

    @Inject
    public NetworkUtil(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public void checkNetworkIsAvailable() {
        if (networkIsNotAvailable())
            throw new NetworkIsNotAvailableException();
    }

    private boolean networkIsNotAvailable() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo == null || !networkInfo.isConnected();
    }
}
