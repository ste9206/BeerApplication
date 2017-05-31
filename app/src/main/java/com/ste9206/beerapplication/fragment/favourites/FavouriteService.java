package com.ste9206.beerapplication.fragment.favourites;

import com.ste9206.beerapplication.listener.OnSortedFavouriteCompleteListener;
import com.ste9206.beerapplication.realm.BeerItems;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.Sort;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by stefano on 31/05/17.
 */

public class FavouriteService implements FavouriteContract.Repository {

    private Realm realm;

    @Inject
    public FavouriteService(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void getAllSortedFavorites(OnSortedFavouriteCompleteListener listener) {

        realm.where(BeerItems.class).equalTo("isFavourite",true)
                .findAllSortedAsync("name", Sort.ASCENDING)
                .asObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(update -> update.isLoaded())
                .subscribe(items -> listener.onSortedCompleted(items),throwable -> listener.onError(throwable));

    }
}
