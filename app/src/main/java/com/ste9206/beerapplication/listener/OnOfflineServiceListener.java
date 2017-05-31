package com.ste9206.beerapplication.listener;

import com.ste9206.beerapplication.realm.BeerItems;

import java.util.Date;

import io.realm.RealmResults;

/**
 * Created by stefano on 29/05/17.
 */

public interface OnOfflineServiceListener {

    void onOfflineDataCompleted(Date date);

    void onUpdateCompleted();

    void onAllBeerItemLoaded(RealmResults<BeerItems> beerItems);

    void onError(Throwable e);
}
