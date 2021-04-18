package com.lomboktech.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lomboktech.mangaapp.R;
import com.lomboktech.mangaapp.model.ModelGenre;

import java.util.List;

public class AdapterGenre extends RecyclerView.Adapter<AdapterGenre.ViewHolder> {

    private List<ModelGenre> items;
    private AdapterGenre.onSelectData onSelectData;
    private Context mContext;

    public interface onSelectData {
        void onSelected(ModelGenre modelGenre);
    }

    public AdapterGenre(Context context, List<ModelGenre> items, AdapterGenre.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelGenre data = items.get(position);

        holder.tvGenre.setText(data.getTitle());
        holder.llGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Class Holder
    class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout llGenre;
        public TextView tvGenre;

        public ViewHolder(View itemView) {
            super(itemView);
            llGenre = itemView.findViewById(R.id.llGenre);
            tvGenre = itemView.findViewById(R.id.tvGenre);
        }
    }
}