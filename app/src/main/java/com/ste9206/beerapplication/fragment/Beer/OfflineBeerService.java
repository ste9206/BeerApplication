package com.ste9206.beerapplication.fragment.Beer;

import com.ste9206.beerapplication.dagger.modules.RealmModule;
import com.ste9206.beerapplication.listener.OnOfflineServiceListener;
import com.ste9206.beerapplication.models.Beer;
import com.ste9206.beerapplication.models.Data;
import com.ste9206.beerapplication.realm.BeerItems;
import com.ste9206.beerapplication.realm.LastUpdate;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;


import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by stefano on 29/05/17.
 */

public class OfflineBeerService implements BeerContract.OfflineService{

    private Realm realm;
    private RealmConfiguration realmConf;
    private LastUpdate lastUpdate;

    @Inject
    public OfflineBeerService(Realm realm, RealmConfiguration realmConf, LastUpdate lastUpdate) {
        this.realm = realm;
        this.realmConf = realmConf;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public void getLastUpdate(OnOfflineServiceListener listener) {

        LastUpdate update =  realm.where(LastUpdate.class).findFirst();

        if(update != null)
        {
         listener.onOfflineDataCompleted(update.getLastUpdate());
        }
        else
         listener.onOfflineDataCompleted(null);
    }

    @Override
    public void updateBeers(Beer beer, OnOfflineServiceListener listener) {

        Observable.fromCallable(() -> {
            try(Realm r = getRealmOnOtherThreads())
            {
                r.executeTransaction(rTrans ->{
                    addBeerItemToRealm(rTrans,beer);
                    updateLastDate(rTrans);
                });
                return true;
            }
          }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(ok ->listener.onUpdateCompleted(),throwable -> listener.onError(throwable));

    }


    private void updateLastDate(Realm realm) {

        LastUpdate upd = realm.where(LastUpdate.class).findFirst();
        if(upd == null)
        {

          lastUpdate.setLastUpdate(Calendar.getInstance().getTime());
          realm.insertOrUpdate(lastUpdate);
        }
        else
        {
            upd.setLastUpdate(Calendar.getInstance().getTime());
            realm.insertOrUpdate(upd);
        }
    }

    private void addBeerItemToRealm(Realm realm, Beer beer) {

        for(Data d : beer.getData())
        {
            BeerItems beerItem = new BeerItems();
            beerItem.setId(getPrimaryKey(realm));
            beerItem.setName(d.getName());
            beerItem.setNameDisplay(d.getNameDisplay());
            beerItem.setFavourite(false);
            beerItem.setDescription(d.getDescription());

            if(d.getLabels() != null) {
                beerItem.setImage(d.getLabels().getMedium());
            }

            realm.insertOrUpdate(beerItem);
        }
    }

    private long getPrimaryKey(Realm realm) {

        Number key = realm.where(BeerItems.class).max("id");

        return (key == null) ? 0 : ((long) key + 1);
    }

    @Override
    public void loadAllBeers(OnOfflineServiceListener listener) {

        realm.where(BeerItems.class)
                .findAllAsync().asObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(update -> update.isLoaded())
                .subscribe(update -> listener.onAllBeerItemLoaded(update),throwable -> listener.onError(throwable));

    }

    private Realm getRealmOnOtherThreads(){
        return Realm.getInstance(realmConf);
    }
}
