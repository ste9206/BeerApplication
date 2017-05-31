package com.ste9206.beerapplication.fragment.description;

import android.os.Bundle;

import com.ste9206.beerapplication.base.BasePresenter;
import com.ste9206.beerapplication.base.BaseView;
import com.ste9206.beerapplication.listener.OnRealmServiceCompleteListener;
import com.ste9206.beerapplication.realm.BeerItems;

/**
 * Created by stefano on 30/05/17.
 */

public interface DescriptionContract {

    interface View extends BaseView{

        void visibleFavoriteInvisibleBorder();

        void visibleBorderInvisibleFavorite();

        void setItemInfo(BeerItems beerItems);

        void likeInserted();

        void likeRemoved();

        void goBack();

        void showError(String message);
    }

    interface Presenter extends BasePresenter{
        
        void onLikeInserted();
        void onLikeRemoved();

        void loadDescription(Bundle arguments);

        void onBackPress();
    }

    interface Repository {
        void getItemDescription(long id, OnRealmServiceCompleteListener listener);

        void addNewLikeToBeer(long id, OnRealmServiceCompleteListener listener);

        void removeLikeToBeer(long id,OnRealmServiceCompleteListener listener);
    }
}
