package com.ste9206.beerapplication.fragment.favourites;

import com.ste9206.beerapplication.base.BasePresenter;
import com.ste9206.beerapplication.base.BaseView;
import com.ste9206.beerapplication.listener.OnSortedFavouriteCompleteListener;
import com.ste9206.beerapplication.realm.BeerItems;

import io.realm.RealmResults;

/**
 * Created by stefano on 31/05/17.
 */

public interface FavouriteContract {

    interface Presenter extends BasePresenter{
        void onBackPress();

        void loadAllSortedFavourites();
    }

    interface View extends BaseView{
        void goBack();

        void updateAdapter(RealmResults<BeerItems> items);

        void showError(String message);
    }

    interface Repository{

        void getAllSortedFavorites(OnSortedFavouriteCompleteListener listener);
    }


}
