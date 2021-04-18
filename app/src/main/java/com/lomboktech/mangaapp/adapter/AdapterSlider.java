package com.lomboktech.mangaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.github.islamkhsh.CardSliderAdapter;
import com.lomboktech.mangaapp.R;
import com.lomboktech.mangaapp.model.ModelSlider;

import java.util.List;

public class AdapterSlider extends CardSliderAdapter<AdapterSlider.MovieViewHolder> {

    private List<ModelSlider> movies;

    public AdapterSlider(List<ModelSlider> movies){
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_slider, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void bindVH(MovieViewHolder viewHolder, int position) {
        Glide.with(viewHolder.itemView)
                .load(movies.get(position).getThumb())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(viewHolder.imgSlider);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView imgSlider;

        public MovieViewHolder(View itemView){
            super(itemView);

            imgSlider = itemView.findViewById(R.id.imgSlider);
            this.itemView = itemView;
        }
    }

    @Override
    public int getItemCount(){
        return movies.size();
    }
}