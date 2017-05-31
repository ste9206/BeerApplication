package com.ste9206.beerapplication.fragment.favourites;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ste9206.beerapplication.R;
import com.ste9206.beerapplication.activity.MainActivity;
import com.ste9206.beerapplication.application.BeerApplication;
import com.ste9206.beerapplication.fragment.Beer.BeerFragment;
import com.ste9206.beerapplication.listener.OnBackPressedListener;
import com.ste9206.beerapplication.realm.BeerItems;
import com.ste9206.beerapplication.utils.AlertMessage;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements OnBackPressedListener,FavouriteContract.View {


    @Inject
    Context context;

    @Inject
    FavouritePresenter presenter;

    @BindView(R.id.favouriteItems)
    RecyclerView recyclerView;

    FavouriteAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_favourite, container, false);

        ButterKnife.bind(this,rootView);
        ((BeerApplication)getActivity().getApplication()).createAppComponent().inject(this);

        ((MainActivity)getActivity()).setOnBackPressListener(this);

        setUpRecyclerView();

        presenter.loadAllSortedFavourites();

        return rootView;
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new FavouriteAdapter(null,context);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onBackPress() {
        presenter.onBackPress();
    }

    @Override
    public void goBack() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.replace(R.id.contentMain,new BeerFragment()).commit();
    }

    @Override
    public void updateAdapter(RealmResults<BeerItems> items) {
        adapter.updateFavourites(items);
    }

    @Override
    public void showError(String message) {
        AlertMessage.newAlertErrorMessage(message,context).show();
    }
}
