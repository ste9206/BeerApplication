package com.ste9206.beerapplication.fragment;

import com.ste9206.beerapplication.base.BasePresenter;
import com.ste9206.beerapplication.base.BaseView;

/**
 * Created by stefano on 29/05/17.
 */

public interface BeerContract {

    interface View extends BaseView{


    }

    interface Presenter extends BasePresenter{

        void loadItems();
    }

    interface OnlineService{

        void getAllBeers();
    }

    interface OfflineService{

    }
}
