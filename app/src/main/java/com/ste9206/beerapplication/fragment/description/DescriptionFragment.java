package com.ste9206.beerapplication.fragment.description;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment implements OnBackPressedListener,DescriptionContract.View{


    @OnClick(R.id.favoriteBorder)
    public void favoriteBorder(){
        presenter.onLikeInserted();
    }

    @OnClick(R.id.favorite)
    public void favorite(){
        presenter.onLikeRemoved();
    }

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.picture)
    ImageView picture;

    @Inject
    Context context;

    @BindView(R.id.favorite)
    ImageView favorite;

    @BindView(R.id.favoriteBorder)
    ImageView favoriteBorder;

    @Inject
    DescriptionPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment_description, container, false);

        ButterKnife.bind(this,rootView);
        ((BeerApplication)getActivity().getApplication()).createAppComponent().inject(this);

        ((MainActivity)getActivity()).setOnBackPressListener(this);

        presenter.loadDescription(getArguments());

        return rootView;
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
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onBackPress() {

        presenter.onBackPress();

    }

    @Override
    public void visibleFavoriteInvisibleBorder() {
        favorite.setVisibility(View.VISIBLE);
        favoriteBorder.setVisibility(View.INVISIBLE);
    }

    @Override
    public void visibleBorderInvisibleFavorite() {
        favorite.setVisibility(View.INVISIBLE);
        favoriteBorder.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItemInfo(BeerItems beerItems) {
        Glide.with(context).load(beerItems.getImage()).error(R.drawable.pint).into(picture);

        favorite.setVisibility(beerItems.isFavourite() ? View.VISIBLE : View.INVISIBLE);
        favoriteBorder.setVisibility(!beerItems.isFavourite() ? View.VISIBLE : View.INVISIBLE);
        description.setText(beerItems.getDescription() == null ? "No description available for this beer." : beerItems.getDescription());
    }

    @Override
    public void likeInserted() {
        Toast.makeText(context,"Beer added to favourites",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void likeRemoved() {
        Toast.makeText(context,"Beer removed to favourites",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goBack() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.replace(R.id.contentMain,new BeerFragment()).commit();
    }

    @Override
    public void showError(String message) {
        AlertMessage.newAlertErrorMessage(message,context).show();
    }
}
