package com.nodomain.mensclothingstore.utils;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nodomain.mensclothingstore.domain.exceptions.NetworkIsNotAvailableException;


public class NetworkUtil {

    private final ConnectivityManager connectivityManager;

    public NetworkUtil(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
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
