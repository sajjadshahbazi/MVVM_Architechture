package com.example.mvvm_architechture.di;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kotlin.jvm.JvmStatic;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class OkHttpModule {


    @JvmStatic
    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor()  {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    @JvmStatic
    @Provides
    @Singleton
    OkHttpClient provideClient(HttpLoggingInterceptor loggingInterceptor)
    {
        OkHttpClient.Builder builder = (new OkHttpClient.Builder())
                .connectTimeout(120, TimeUnit.SECONDS)// Set connection timeout
                .readTimeout(120, TimeUnit.SECONDS)// Read timeout
                .writeTimeout(120, TimeUnit.SECONDS)// Write timeout
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                            request = request.newBuilder()
                                    .addHeader("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1ODMwMDQ0NzN9.eLV1AjPjH-d_57M02JJfVYlDMsuRT35Wjt4FWXspED0")
                                    .addHeader("Content-Type", "application/json")
                                    .build();
                        return chain.proceed(request);
                    }
                });
        return builder.build();

    }


}
