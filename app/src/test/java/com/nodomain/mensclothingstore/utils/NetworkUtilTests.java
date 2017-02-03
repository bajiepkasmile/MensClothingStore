package com.nodomain.mensclothingstore.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nodomain.mensclothingstore.domain.exceptions.NetworkIsNotAvailableException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.mockito.Mockito.*;


public class NetworkUtilTests {

    @Test
    public void checkingNetworkDoNotThrowsExceptionWhenNetworkIsAvailable() {
        NetworkInfo networkInfo = mock(NetworkInfo.class);
        when(networkInfo.isConnected()).thenReturn(true);

        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);

        Context context = mock(Context.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);

        NetworkUtil networkUtil = new NetworkUtil(context);

        networkUtil.checkNetworkIsAvailable();
    }

    @Test(expected = NetworkIsNotAvailableException.class)
    public void checkingNetworkThrowsExceptionWhenNetworkInfoIsNull() {
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(null);

        Context context = mock(Context.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);

        NetworkUtil networkUtil = new NetworkUtil(context);

        networkUtil.checkNetworkIsAvailable();
        fail();
    }

    @Test(expected = NetworkIsNotAvailableException.class)
    public void checkingNetworkThrowsExceptionWhenNetworkInfoIsNotConnected() {
        NetworkInfo networkInfo = mock(NetworkInfo.class);
        when(networkInfo.isConnected()).thenReturn(false);

        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);

        Context context = mock(Context.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);

        NetworkUtil networkUtil = new NetworkUtil(context);

        networkUtil.checkNetworkIsAvailable();
        fail();
    }
}
