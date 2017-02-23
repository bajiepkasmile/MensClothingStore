package com.nodomain.mensclothingstore.di.components;


import com.nodomain.mensclothingstore.di.modules.ApplicationModule;
import com.nodomain.mensclothingstore.di.modules.InteractorsModule;
import com.nodomain.mensclothingstore.di.modules.MainActivityModule;
import com.nodomain.mensclothingstore.di.modules.StoragesModule;
import com.nodomain.mensclothingstore.domain.receivers.ConnectivityChangeReceiver;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                InteractorsModule.class,
                StoragesModule.class
        }
)
public interface ApplicationComponent {

    MainActivitySubComponent plusMainActivitySubComponent(MainActivityModule module);

    void inject(ConnectivityChangeReceiver receiver);
}
