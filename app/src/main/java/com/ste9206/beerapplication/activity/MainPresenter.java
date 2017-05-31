package com.ste9206.beerapplication.activity;

import com.ste9206.beerapplication.base.BaseView;

import javax.inject.Inject;

/**
 * Created by stefano on 29/05/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;


    @Inject
    public MainPresenter(){

    }

    @Override
    public void setView(BaseView view) {
        this.view = (MainContract.View)view;

        loadFragment();
    }

    private void loadFragment() {
        view.loadFirstFragment();
    }

    @Override
    public void onDestroy() {
      view = null;
    }

    @Override
    public void loadFavouriteBeers() {
        view.loadFavouriteFragment();
    }

    @Override
    public void loadBeers() {
      loadFragment();
    }
}
