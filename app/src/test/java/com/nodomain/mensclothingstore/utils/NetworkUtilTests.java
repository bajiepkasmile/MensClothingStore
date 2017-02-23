package com.nodomain.mensclothingstore.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.mockito.Mockito.*;


public class NetworkUtilTests {

    @Test
    public void networkIsAvailableWhenNetworkInfoIsConnected() {
        NetworkInfo networkInfo = mock(NetworkInfo.class);
        when(networkInfo.isConnected()).thenReturn(true);

        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);

        Context context = mock(Context.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);

        NetworkUtil networkUtil = new NetworkUtil(context);

        if (!networkUtil.networkIsAvailable()) {
            fail();
        }
    }

    @Test
    public void networkIsNotAvailableWhenNetworkInfoIsNull() {
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(null);

        Context context = mock(Context.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);

        NetworkUtil networkUtil = new NetworkUtil(context);

        if (networkUtil.networkIsAvailable()) {
            fail();
        }
    }

    @Test
    public void networkIsNotAvailableWhenNetworkInfoIsNotConnected() {
        NetworkInfo networkInfo = mock(NetworkInfo.class);
        when(networkInfo.isConnected()).thenReturn(false);

        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);

        Context context = mock(Context.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);

        NetworkUtil networkUtil = new NetworkUtil(context);

        if (networkUtil.networkIsAvailable()) {
            fail();
        }
    }
}
