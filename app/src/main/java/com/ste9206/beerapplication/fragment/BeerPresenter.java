package com.ste9206.beerapplication.fragment;

import com.ste9206.beerapplication.base.BaseView;

import javax.inject.Inject;

/**
 * Created by stefano on 29/05/17.
 */

public class BeerPresenter implements BeerContract.Presenter {

    private BeerContract.View view;

    private OnlineBeerService service;

    @Inject
    public BeerPresenter(OnlineBeerService service) {
        this.service = service;
    }

    @Override
    public void setView(BaseView view) {
        this.view = (BeerContract.View)view;
    }

    @Override
    public void onDestroy() {
       view = null;
    }

    @Override
    public void loadItems() {
      service.getAllBeers();
    }
}
