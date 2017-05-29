package com.ste9206.beerapplication.dagger.components;

import com.ste9206.beerapplication.dagger.modules.RealmModule;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by stefano on 29/05/17.
 */
@Component(modules = RealmModule.class)
public interface RealmComponent {
    Realm realm();
}
