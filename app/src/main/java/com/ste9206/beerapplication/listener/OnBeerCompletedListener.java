package com.ste9206.beerapplication.listener;

import com.ste9206.beerapplication.models.Beer;

/**
 * Created by stefano on 29/05/17.
 */

public interface OnBeerCompletedListener {

    void onBeerCompleted(Beer beer);
    void onBeerError(Throwable throwable);

}
