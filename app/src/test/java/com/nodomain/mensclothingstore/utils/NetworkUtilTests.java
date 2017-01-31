package com.nodomain.mensclothingstore.utils;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nodomain.mensclothingstore.domain.exceptions.NetworkIsNotAvailableException;

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
        NetworkUtil networkUtil = new NetworkUtil(connectivityManager);

        networkUtil.checkNetworkIsAvailable();
    }

    @Test(expected = NetworkIsNotAvailableException.class)
    public void checkingNetworkThrowsExceptionWhenNetworkInfoIsNull() {
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(null);
        NetworkUtil networkUtil = new NetworkUtil(connectivityManager);

        networkUtil.checkNetworkIsAvailable();
        fail();
    }

    @Test(expected = NetworkIsNotAvailableException.class)
    public void checkingNetworkThrowsExceptionWhenNetworkInfoIsNotConnected() {
        NetworkInfo networkInfo = mock(NetworkInfo.class);
        when(networkInfo.isConnected()).thenReturn(false);
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);
        NetworkUtil networkUtil = new NetworkUtil(connectivityManager);

        networkUtil.checkNetworkIsAvailable();
        fail();
    }
}
