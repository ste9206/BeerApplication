package com.ste9206.beerapplication.fragment.description;

import android.util.Log;

import com.ste9206.beerapplication.listener.OnRealmServiceCompleteListener;
import com.ste9206.beerapplication.realm.BeerItems;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by stefano on 30/05/17.
 */

public class RealmService implements DescriptionContract.Repository {

    private Realm realm;
    private RealmConfiguration realmConfiguration;

    @Inject
    public RealmService(Realm realm, RealmConfiguration realmConfiguration) {
        this.realm = realm;
        this.realmConfiguration = realmConfiguration;
    }

    @Override
    public void getItemDescription(long id, OnRealmServiceCompleteListener listener) {

        realm.where(BeerItems.class).equalTo("id",id)
                .findFirstAsync()
                .asObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(update -> update.isLoaded())
                .subscribe(item -> listener.onServiceCompleted((BeerItems)item),throwable -> listener.onError(throwable));
    }

    @Override
    public void addNewLikeToBeer(long id, OnRealmServiceCompleteListener listener) {
        Observable.fromCallable(() -> {
            try(Realm r = getRealmOnOtherThreads())
            {
                r.executeTransaction(rTrans ->{
                    BeerItems beerItems = rTrans.where(BeerItems.class).equalTo("id",id).findFirst();
                    beerItems.setFavourite(true);
                    rTrans.insertOrUpdate(beerItems);
                });
                return true;
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(s->listener.onAddCompleted(),throwable -> listener.onError(throwable));
    }

    @Override
    public void removeLikeToBeer(long id, OnRealmServiceCompleteListener listener) {
        Observable.fromCallable(() -> {
            try(Realm r = getRealmOnOtherThreads())
            {
                r.executeTransaction(rTrans ->{
                    BeerItems beerItems = rTrans.where(BeerItems.class).equalTo("id",id).findFirst();
                    beerItems.setFavourite(false);
                    rTrans.insertOrUpdate(beerItems);
                });
                return true;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->listener.onRemoveCompleted(),throwable -> listener.onError(throwable));
    }


    public Realm getRealmOnOtherThreads(){
        return Realm.getInstance(realmConfiguration);
    }
}
