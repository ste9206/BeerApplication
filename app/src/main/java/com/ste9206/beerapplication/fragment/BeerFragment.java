package com.ste9206.beerapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ste9206.beerapplication.R;
import com.ste9206.beerapplication.activity.MainPresenter;
import com.ste9206.beerapplication.application.BeerApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeerFragment extends Fragment implements BeerContract.View{


    @Inject
    BeerPresenter presenter;

    @BindView(R.id.listBeers)
    RecyclerView listItems;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
       View rootView = inflater.inflate(R.layout.fragment_beer, container, false);

        ButterKnife.bind(this,rootView);
        ((BeerApplication)getActivity().getApplication()).createAppComponent().inject(this);

        presenter.loadItems();

        return rootView;
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
}
