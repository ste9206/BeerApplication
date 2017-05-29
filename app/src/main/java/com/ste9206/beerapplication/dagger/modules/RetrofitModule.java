package com.ste9206.beerapplication.dagger.modules;

import com.ste9206.beerapplication.utils.Constants;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stefano on 29/05/17.
 */
@Module
public class RetrofitModule {

    @Provides
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }
}
