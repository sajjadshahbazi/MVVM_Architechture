package com.example.mvvm_architechture.base;


import android.app.Application;
import com.example.mvvm_architechture.di.ActivityBindingModule;
import com.example.mvvm_architechture.di.ContextModule;
import com.example.mvvm_architechture.di.ViewModelModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ContextModule.class,
        ApplicationModule.class,
        AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ViewModelModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}
