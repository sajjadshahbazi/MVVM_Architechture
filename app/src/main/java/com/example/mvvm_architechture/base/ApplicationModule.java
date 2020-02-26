package com.example.mvvm_architechture.base;

import com.example.mvvm_architechture.domain.ApiServices;
import com.example.mvvm_architechture.utils.ConstantsApplication;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(ConstantsApplication.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static ApiServices provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ApiServices.class);
    }
}
