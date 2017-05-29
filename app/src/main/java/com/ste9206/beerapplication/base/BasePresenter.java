package com.ste9206.beerapplication.base;

/**
 * Created by stefano on 29/05/17.
 */

public interface BasePresenter {

    void setView(BaseView view);
    void onDestroy();
}
