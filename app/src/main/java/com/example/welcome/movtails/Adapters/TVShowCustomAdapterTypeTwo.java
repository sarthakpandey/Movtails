package com.example.welcome.movtails.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.welcome.movtails.Constants;
import com.example.welcome.movtails.Network.TVShows.TVShowGenreGiver;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseGeneral;
import com.example.welcome.movtails.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class TVShowCustomAdapterTypeTwo extends RecyclerView.Adapter<TVShowCustomAdapterTypeTwo.ViewHolderPro> {

    Context mContext;
    ArrayList<TVShowResponseGeneral> mTVShows;

    public TVShowCustomAdapterTypeTwo(Context mContext, ArrayList<TVShowResponseGeneral> mTVShows) {
        this.mContext = mContext;
        this.mTVShows = mTVShows;
    }

    @Override
    public ViewHolderPro onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderPro(LayoutInflater.from(mContext).inflate(R.layout.adapter_two_layout_next,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolderPro holder, int position) {

        TVShowResponseGeneral tvshow = mTVShows.get(position);

        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(700);

        holder.progress.show();

        Glide.with(mContext).load(Constants.IMAGE_LOADING_BASE_URL_780 + tvshow.getBackdrop_path())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        holder.progress.hide();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.progress.hide();
                        return false;
                    }
                }).animate(animation)
                .into(holder.imageView);

        if(tvshow.getName() != null){
            holder.titleTextView.setText(tvshow.getName());
        }else{
            holder.titleTextView.setText("No Title");
        }

        if(tvshow.getVote_average() != null && tvshow.getVote_average() >= 0){
            holder.ratingTextView.setText(tvshow.getVote_average() + "\u2B50");
        }else {
            holder.ratingTextView.setVisibility(View.GONE);
        }

        String sample = "";
        for (int i = 0; i < tvshow.getGenre_ids().size(); i++) {
            if (tvshow.getGenre_ids().get(i) == null) continue;
            if (TVShowGenreGiver.giveGenre(tvshow.getGenre_ids().get(i)) == null) continue;
            sample += TVShowGenreGiver.giveGenre(tvshow.getGenre_ids().get(i)) + ", ";
        }
        if (!sample.isEmpty())
            holder.genreTextView.setText(sample.substring(0, sample.length() - 2));
        else
            holder.genreTextView.setText("");

    }

    @Override
    public int getItemCount() {
        return mTVShows.size();
    }

    public class ViewHolderPro extends RecyclerView.ViewHolder{

        public CardView cardView;
        public RelativeLayout relativeLayout;
        public ImageView imageView;
        public TextView genreTextView;
        public TextView titleTextView;
        public TextView ratingTextView;
        public AVLoadingIndicatorView progress;

        public ViewHolderPro(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            relativeLayout = itemView.findViewById(R.id.imageRelative);
            imageView = itemView.findViewById(R.id.imageView);
            genreTextView = itemView.findViewById(R.id.genre);
            titleTextView = itemView.findViewById(R.id.title);
            ratingTextView = itemView.findViewById(R.id.rating);
            progress = itemView.findViewById(R.id.avi_progress);

            relativeLayout.getLayoutParams().width = (int)(mContext.getResources().getDisplayMetrics().widthPixels * 0.77);
            relativeLayout.getLayoutParams().height = (int)((mContext.getResources().getDisplayMetrics().widthPixels * 0.77) / 1.77);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

}
