package com.lomboktech.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.lomboktech.mangaapp.R;
import com.lomboktech.mangaapp.model.ModelChapter;

import java.util.List;

public class AdapterImageChapter extends PagerAdapter {

    private List<ModelChapter> items;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterImageChapter(List<ModelChapter> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item_detail_chapter, container, false);

        final ModelChapter data = items.get(position);

        ImageView imageView;
        imageView = view.findViewById(R.id.imgPhoto);

        TextView tvPagination;
        tvPagination = view.findViewById(R.id.tvPagination);
        tvPagination.setText("Hal. " + data.getImageNumber());

        Glide.with(context)
                .load(data.getChapterImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(imageView);

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}