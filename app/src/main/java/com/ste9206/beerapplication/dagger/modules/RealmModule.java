package com.ste9206.beerapplication.dagger.modules;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by stefano on 29/05/17.
 */
@Module
public class RealmModule {

    @Provides
    public RealmConfiguration provideRealmConfiguration(){
        return new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
    }

    @Provides
    public Realm provideRealm(RealmConfiguration realmConfiguration)
    {
        return Realm.getInstance(realmConfiguration);
    }

}
