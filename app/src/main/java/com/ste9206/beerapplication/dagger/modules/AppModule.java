package com.ste9206.beerapplication.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by stefano on 29/05/17.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
}
