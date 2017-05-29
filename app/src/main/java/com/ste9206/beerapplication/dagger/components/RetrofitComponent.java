package com.ste9206.beerapplication.dagger.components;

import com.ste9206.beerapplication.dagger.modules.RetrofitModule;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by stefano on 29/05/17.
 */
@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {

    Retrofit retrofit();
}
