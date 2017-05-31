package com.ste9206.beerapplication.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ste9206.beerapplication.application.BeerApplication;
import com.ste9206.beerapplication.R;
import com.ste9206.beerapplication.fragment.Beer.BeerFragment;
import com.ste9206.beerapplication.fragment.favourites.FavouriteFragment;
import com.ste9206.beerapplication.listener.OnBackPressedListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    OnBackPressedListener onBackPressListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((BeerApplication)getApplication()).createAppComponent().inject(this);

        setOtherViewSettings();

    }

    private void setOtherViewSettings() {

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    public void setOnBackPressListener(OnBackPressedListener onBackPressListener) {
        this.onBackPressListener = onBackPressListener;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }

        if(onBackPressListener != null)
        {
           onBackPressListener.onBackPress();
        }

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.beers)
        {
          presenter.loadBeers();
        }

        else if (id == R.id.favouriteBeers)
        {
          presenter.loadFavouriteBeers();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void loadFirstFragment() {
        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().replace(R.id.contentMain, new BeerFragment()).commit();
    }

    @Override
    public void loadFavouriteFragment()
    {
        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().replace(R.id.contentMain, new FavouriteFragment()).commit();
    }
}
