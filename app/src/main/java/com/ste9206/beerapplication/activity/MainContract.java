package com.ste9206.beerapplication.activity;

import com.ste9206.beerapplication.base.BasePresenter;
import com.ste9206.beerapplication.base.BaseView;

/**
 * Created by stefano on 29/05/17.
 */

public interface MainContract {

    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView {

        void loadFirstFragment();
    }
}
