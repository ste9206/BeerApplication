package com.ste9206.beerapplication.application;

import android.app.Application;

import com.ste9206.beerapplication.dagger.components.AppComponent;
import com.ste9206.beerapplication.dagger.components.DaggerAppComponent;
import com.ste9206.beerapplication.dagger.components.DaggerRealmComponent;
import com.ste9206.beerapplication.dagger.components.DaggerRetrofitComponent;
import com.ste9206.beerapplication.dagger.components.RealmComponent;
import com.ste9206.beerapplication.dagger.components.RetrofitComponent;
import com.ste9206.beerapplication.dagger.modules.AppModule;
import com.ste9206.beerapplication.dagger.modules.RealmModule;
import com.ste9206.beerapplication.dagger.modules.RetrofitModule;

import io.realm.Realm;

/**
 * Created by stefano on 29/05/17.
 */

public class BeerApplication extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        createAppComponent();
    }

    public AppComponent createAppComponent() {

        appComponent = DaggerAppComponent.builder()
                          .appModule(new AppModule(this))
                          .retrofitComponent(createRetrofitComponent())
                          .realmComponent(createRealmComponent())
                          .build();

        return appComponent;
    }

    public RetrofitComponent createRetrofitComponent(){
        RetrofitComponent component = DaggerRetrofitComponent
                                      .builder()
                                      .retrofitModule(new RetrofitModule())
                                      .build();

        return component;

    }

    public RealmComponent createRealmComponent(){
        RealmComponent component = DaggerRealmComponent.builder()
                .realmModule(new RealmModule())
                .build();

        return component;
    }


}
