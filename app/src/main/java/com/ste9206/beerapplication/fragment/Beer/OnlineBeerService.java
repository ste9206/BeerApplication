package com.ste9206.beerapplication.fragment.Beer;

import com.ste9206.beerapplication.listener.OnBeerCompletedListener;
import com.ste9206.beerapplication.service.APIService;
import com.ste9206.beerapplication.utils.Constants;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by stefano on 29/05/17.
 */

public class OnlineBeerService implements BeerContract.OnlineService {

    private Retrofit retrofit;

    @Inject
    public OnlineBeerService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void getAllBeers(OnBeerCompletedListener listener) {

        APIService service = retrofit.create(APIService.class);

                service.getAllBeers(Constants.APIKEY,Constants.FORMAT,Constants.STYLEID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe( b -> listener.onBeerCompleted(b), throwable -> listener.onBeerError(throwable) );

    }



}
