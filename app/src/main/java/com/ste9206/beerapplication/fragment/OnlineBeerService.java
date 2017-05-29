package com.ste9206.beerapplication.fragment;

import com.ste9206.beerapplication.models.Beer;
import com.ste9206.beerapplication.service.APIService;
import com.ste9206.beerapplication.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by stefano on 29/05/17.
 */

public class OnlineBeerService implements BeerContract.OnlineService {

    private Retrofit retrofit;

    @Inject
    public OnlineBeerService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void getAllBeers() {
        APIService service = retrofit.create(APIService.class);

                service.getAllBeers(Constants.APIKEY,Constants.FORMAT,Constants.STYLEID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe( b -> ok(b), Throwable::printStackTrace  );

    }

    private void ok(Beer beer) {


        beer.data.forEach(s->System.out.println(s.getName()));

    }


}
