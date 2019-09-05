package com.example.taxipot_android.di.component;

import com.example.taxipot_android.di.application.BaseApplication;
import com.example.taxipot_android.di.module.ViewModelFactoryModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {
        AndroidInjectionModule.class,
        ViewModelFactoryModule.class
})
public interface BaseComponent extends AndroidInjector<BaseApplication> {
    @Component.Factory
    interface Factory {
        BaseComponent build(@BindsInstance BaseApplication application);
    }
}


/*
@Component(modules = [
    AndroidInjectionModule::class,
    ViewModelFactoryModule::class
])
interface BaseComponent : AndroidInjector<BaseApplication>{

    @Component.Factory
    interface Factory{
        fun build(@BindsInstance application : BaseApplication) : BaseComponent
    }
}
 */