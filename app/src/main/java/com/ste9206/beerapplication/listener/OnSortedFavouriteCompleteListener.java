package com.ste9206.beerapplication.listener;

import com.ste9206.beerapplication.realm.BeerItems;

import io.realm.RealmResults;

/**
 * Created by stefano on 31/05/17.
 */

public interface OnSortedFavouriteCompleteListener {
    void onSortedCompleted(RealmResults<BeerItems> items);
    void onError(Throwable throwable);
}
