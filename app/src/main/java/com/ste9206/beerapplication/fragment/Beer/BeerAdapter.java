package com.ste9206.beerapplication.fragment.Beer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ste9206.beerapplication.R;
import com.ste9206.beerapplication.listener.OnItemClickedListener;
import com.ste9206.beerapplication.models.Beer;
import com.ste9206.beerapplication.realm.BeerItems;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

/**
 * Created by stefano on 30/05/17.
 */

public class BeerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RealmResults<BeerItems> beerItems;
    private Context context;
    private OnItemClickedListener listener;


    public BeerAdapter(RealmResults<BeerItems> beerItems, Context context, OnItemClickedListener listener) {
        this.beerItems = beerItems;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(beerItems != null) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beer, parent, false);
           BeerHolder beerHolder = new BeerHolder(view);

           return beerHolder;
       }
       return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
     if(beerItems != null){
         BeerHolder mHolder = (BeerHolder)holder;
         BeerItems items = beerItems.get(position);

         mHolder.beerInfo.setText(items.getNameDisplay());
         mHolder.beerName.setText(items.getName());
         Glide.with(context).load(items.getImage()).error(R.drawable.pint).centerCrop().into(mHolder.picBeer);

     }
    }

    @Override
    public int getItemCount() {
        if(beerItems == null)
            return 0;
        else
          return beerItems.size();
    }

    public void updateBeer(RealmResults<BeerItems> beerItems) {
        this.beerItems = beerItems;
        notifyDataSetChanged();
    }


    public class BeerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.beerName)
        TextView beerName;

        @BindView(R.id.picBeer)
        ImageView picBeer;

        @BindView(R.id.beerInfo)
        TextView beerInfo;

        public BeerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
          listener.onItemClicked(beerItems.get(getAdapterPosition()).getId());
        }
    }
}
