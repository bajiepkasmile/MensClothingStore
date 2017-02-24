package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.data.datasources.remote.impl.ApiConstants;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.McsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class DataSourcesModule {

    @Singleton
    @Provides
    McsApi provideManyfaceApi() {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(McsApi.class);
    }
}
