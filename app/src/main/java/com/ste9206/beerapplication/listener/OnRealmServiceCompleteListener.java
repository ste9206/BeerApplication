package com.ste9206.beerapplication.listener;

import com.ste9206.beerapplication.realm.BeerItems;

import rx.functions.Action1;

/**
 * Created by stefano on 30/05/17.
 */

public interface OnRealmServiceCompleteListener {
    
    void onServiceCompleted(BeerItems beerItems);

    void onError(Throwable throwable);

    void onAddCompleted();

    void onRemoveCompleted();
}
