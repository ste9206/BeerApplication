package com.ste9206.beerapplication.fragment.favourites;

import com.ste9206.beerapplication.base.BaseView;
import com.ste9206.beerapplication.listener.OnSortedFavouriteCompleteListener;
import com.ste9206.beerapplication.realm.BeerItems;

import javax.inject.Inject;

import io.realm.RealmResults;

/**
 * Created by stefano on 31/05/17.
 */

public class FavouritePresenter implements FavouriteContract.Presenter,OnSortedFavouriteCompleteListener {

    private FavouriteContract.View view;
    private FavouriteService service;

    @Inject
    public FavouritePresenter(FavouriteService service) {
        this.service = service;
    }

    @Override
    public void setView(BaseView view) {
        this.view = (FavouriteContract.View)view;
    }

    @Override
    public void onDestroy() {
      view = null;
    }


    @Override
    public void onBackPress() {
        view.goBack();
    }

    @Override
    public void loadAllSortedFavourites() {
        service.getAllSortedFavorites(this);
    }

    @Override
    public void onSortedCompleted(RealmResults<BeerItems> items) {
        view.updateAdapter(items);
    }

    @Override
    public void onError(Throwable throwable) {
      view.showError(throwable.getMessage());
    }
}
