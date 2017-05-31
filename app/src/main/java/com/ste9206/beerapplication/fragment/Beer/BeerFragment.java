package com.ste9206.beerapplication.fragment.Beer;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ste9206.beerapplication.R;
import com.ste9206.beerapplication.activity.MainActivity;
import com.ste9206.beerapplication.application.BeerApplication;
import com.ste9206.beerapplication.fragment.description.DescriptionFragment;
import com.ste9206.beerapplication.listener.OnBackPressedListener;
import com.ste9206.beerapplication.listener.OnItemClickedListener;
import com.ste9206.beerapplication.models.Beer;
import com.ste9206.beerapplication.realm.BeerItems;
import com.ste9206.beerapplication.utils.AlertMessage;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeerFragment extends Fragment implements BeerContract.View, OnItemClickedListener, OnBackPressedListener{


    //tomorrow == handle errors on various listeners !!!

    @Inject
    BeerPresenter presenter;

    @Inject
    Context context;

    @BindView(R.id.listBeers)
    RecyclerView listItems;

    BeerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
       View rootView = inflater.inflate(R.layout.fragment_beer, container, false);

        ButterKnife.bind(this,rootView);
        ((BeerApplication)getActivity().getApplication()).createAppComponent().inject(this);

        ((MainActivity) getActivity()).setOnBackPressListener(this);

        presenter.loadItems();

        setRecyclerViewSchema();


        return rootView;
    }



    private void setRecyclerViewSchema() {
        adapter = new BeerAdapter(null,context,this);
        listItems.setHasFixedSize(true);
        listItems.setLayoutManager(new LinearLayoutManager(context));
        listItems.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showError(String message) {
        AlertMessage.newAlertErrorMessage(message,context).show();
    }

    @Override
    public void showBeers(RealmResults<BeerItems> beerItems) {

        adapter.updateBeer(beerItems);
    }

    @Override
    public void openDescriptionFragment(Bundle bundle) {
        Fragment fragment = new DescriptionFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(R.id.contentMain,fragment).commit();
    }

    @Override
    public void finishApp() {
     getActivity().finish();
    }

    @Override
    public void onBackPress() {
     presenter.onBackPress();

    }

    @Override
    public void onItemClicked(long position) {
        presenter.onRecyclerItemClicked(position);
    }
}
