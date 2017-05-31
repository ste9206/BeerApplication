package com.ste9206.beerapplication.fragment.Beer;

import android.os.Bundle;

import com.ste9206.beerapplication.base.BaseView;
import com.ste9206.beerapplication.listener.OnBeerCompletedListener;
import com.ste9206.beerapplication.listener.OnOfflineServiceListener;
import com.ste9206.beerapplication.models.Beer;
import com.ste9206.beerapplication.realm.BeerItems;
import com.ste9206.beerapplication.utils.DateTime;

import java.util.Date;

import javax.inject.Inject;

import io.realm.RealmResults;

/**
 * Created by stefano on 29/05/17.
 */

public class BeerPresenter implements BeerContract.Presenter, OnBeerCompletedListener,OnOfflineServiceListener {

    private BeerContract.View view;

    private OnlineBeerService onLineService;
    private OfflineBeerService offlineBeerService;

    @Inject
    public BeerPresenter(OnlineBeerService onLineService, OfflineBeerService offlineBeerService) {
        this.onLineService = onLineService;
        this.offlineBeerService = offlineBeerService;
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

      offlineBeerService.getLastUpdate(this);

    }

    @Override
    public void onRecyclerItemClicked(long position) {
        Bundle bundle = new Bundle();
        bundle.putLong("position",position);
        view.openDescriptionFragment(bundle);
    }

    @Override
    public void onBackPress() {
        view.finishApp();
    }

    @Override
    public void onBeerCompleted(Beer beer) {
      offlineBeerService.updateBeers(beer,this);
    }

    @Override
    public void onBeerError(Throwable throwable) {
      view.showError(throwable.getMessage());
    }

    @Override
    public void onOfflineDataCompleted(Date date) {

        if(date == null || date.before(DateTime.todayDate()))
            onLineService.getAllBeers(this);
        else
          offlineBeerService.loadAllBeers(this);
    }

    @Override
    public void onUpdateCompleted() {
      offlineBeerService.loadAllBeers(this);
    }

    @Override
    public void onAllBeerItemLoaded(RealmResults<BeerItems> beerItems) {
        view.showBeers(beerItems);
    }

    @Override
    public void onError(Throwable e) {
        view.showError(e.getMessage());
    }

}
