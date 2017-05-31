package com.ste9206.beerapplication.fragment.description;

import android.os.Bundle;

import com.ste9206.beerapplication.base.BaseView;
import com.ste9206.beerapplication.listener.OnRealmServiceCompleteListener;
import com.ste9206.beerapplication.realm.BeerItems;

import javax.inject.Inject;

/**
 * Created by stefano on 30/05/17.
 */

public class DescriptionPresenter implements DescriptionContract.Presenter, OnRealmServiceCompleteListener {

    private DescriptionContract.View view;
    private RealmService service;
    private long id;

    @Inject
    public DescriptionPresenter(RealmService service) {
        this.service = service;
    }

    @Override
    public void setView(BaseView view) {
        this.view = (DescriptionContract.View)view;
    }

    @Override
    public void onDestroy() {
     view = null;
    }

    @Override
    public void onLikeInserted() {
        //save to realm this
        service.addNewLikeToBeer(id,this);

    }

    @Override
    public void onLikeRemoved() {
        service.removeLikeToBeer(id,this);

    }

    @Override
    public void loadDescription(Bundle arguments) {
        id = arguments.getLong("position");
        service.getItemDescription(id,this);
    }

    @Override
    public void onBackPress() {
        view.goBack();
    }


    @Override
    public void onServiceCompleted(BeerItems beerItems) {
        view.setItemInfo(beerItems);
    }

    @Override
    public void onError(Throwable throwable) {
     view.showError(throwable.getMessage());
    }

    @Override
    public void onAddCompleted() {
        view.likeInserted();
        view.visibleFavoriteInvisibleBorder();
    }

    @Override
    public void onRemoveCompleted() {
        view.likeRemoved();
        view.visibleBorderInvisibleFavorite();
    }
}
