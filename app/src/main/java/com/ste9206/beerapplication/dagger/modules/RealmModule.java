package com.ste9206.beerapplication.dagger.modules;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;

/**
 * Created by stefano on 29/05/17.
 */
@Module
public class RealmModule {

    @Provides
    public RealmObservableFactory provideRealmObservableFactory(){
        return new RealmObservableFactory();
    }

    @Provides
    public RealmConfiguration provideRealmConfiguration(RealmObservableFactory realmObservableFactory){
        return new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().rxFactory(provideRealmObservableFactory()).build();
    }

    @Provides
    public Realm provideRealm(RealmConfiguration realmConfiguration)
    {
        return Realm.getInstance(realmConfiguration);
    }

}
