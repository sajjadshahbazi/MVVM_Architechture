package com.example.mvvm_architechture.di;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class OkHttpModule {

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor()  {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


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
                        Request original = chain.request();
                        Request newRequest = original.newBuilder()
                                .addHeader("Accept", "application/json")
                                .addHeader("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1ODMzMDY3NjMsInVzZXJfaWQiOjJ9.za5lq_aSsSrW0idqlWoSr5O1-46b95G-sED_0YTKQXY")
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(newRequest);
                    }
                });
        return builder.build();
    }
}
