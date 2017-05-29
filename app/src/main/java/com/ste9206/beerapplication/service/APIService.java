package com.ste9206.beerapplication.service;

import com.ste9206.beerapplication.models.Beer;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by stefano on 29/05/17.
 */

public interface APIService {

    @GET("beers")
    Flowable<Beer> getAllBeers(@Query("key")String APIkey,
                                     @Query("format")String format,
                                     @Query("styleId")String styleId);
}
