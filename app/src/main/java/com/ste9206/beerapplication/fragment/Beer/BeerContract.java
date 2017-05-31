package com.ste9206.beerapplication.fragment.Beer;

import android.os.Bundle;

import com.ste9206.beerapplication.base.BasePresenter;
import com.ste9206.beerapplication.base.BaseView;
import com.ste9206.beerapplication.listener.OnBeerCompletedListener;
import com.ste9206.beerapplication.listener.OnOfflineServiceListener;
import com.ste9206.beerapplication.models.Beer;
import com.ste9206.beerapplication.realm.BeerItems;

import io.realm.RealmResults;

/**
 * Created by stefano on 29/05/17.
 */

public interface BeerContract {

    interface View extends BaseView{


        void showError(String message);

        void showBeers(RealmResults<BeerItems> beerItems);

        void openDescriptionFragment(Bundle bundle);

        void finishApp();
    }

    interface Presenter extends BasePresenter{

        void loadItems();

        void onRecyclerItemClicked(long position);

        void onBackPress();
    }

    interface OnlineService{

        void getAllBeers(OnBeerCompletedListener listener);
    }

    interface OfflineService{

        void updateBeers(Beer beer, OnOfflineServiceListener listener);
        void getLastUpdate(OnOfflineServiceListener listener);
        void loadAllBeers(OnOfflineServiceListener listener);

    }
}
