package com.nodomain.mensclothingstore.domain.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nodomain.mensclothingstore.App;
import com.nodomain.mensclothingstore.domain.events.OnNetworkAvailableEvent;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;


public class ConnectivityChangeReceiver extends BroadcastReceiver {

    @Inject
    EventBus eventBus;
    @Inject
    NetworkUtil networkUtil;

    @Override
    public void onReceive(Context context, Intent intent) {
        App.getApplicationComponent(context).inject(this);

        if (networkUtil.networkIsAvailable()) {
            eventBus.postSticky(new OnNetworkAvailableEvent());
        }
    }
}
