package com.ste9206.beerapplication.dagger.components;

import com.ste9206.beerapplication.activity.MainActivity;
import com.ste9206.beerapplication.dagger.modules.AppModule;
import com.ste9206.beerapplication.fragment.Beer.BeerFragment;
import com.ste9206.beerapplication.fragment.description.DescriptionFragment;
import com.ste9206.beerapplication.fragment.favourites.FavouriteFragment;

import dagger.Component;

/**
 * Created by stefano on 29/05/17.
 */
@Component(modules = AppModule.class, dependencies = {RetrofitComponent.class, RealmComponent.class})
public interface AppComponent {

    void inject(MainActivity activity);

    void inject(BeerFragment beerFragment);

    void inject(DescriptionFragment descriptionFragment);

    void inject(FavouriteFragment favouriteFragment);
}
