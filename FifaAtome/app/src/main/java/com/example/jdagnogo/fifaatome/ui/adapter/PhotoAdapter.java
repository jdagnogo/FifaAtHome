package com.example.jdagnogo.fifaatome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.utils.ImageUtils;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    ArrayList<String> photos;
    String photoSelected;
    private ItemClickListener mClickListener;

    public PhotoAdapter(ArrayList<String> photos, String photoSelected) {
        this.photos = photos;
        this.photoSelected = photoSelected;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo_adapter, parent, false);
        return new PhotoAdapter.PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.getPhoto().setImageDrawable(ImageUtils.getProfileDrawableFromName(photos.get(position)));
        if (photoSelected.equals(photos.get(position))) {
            holder.getSelected().setVisibility(View.VISIBLE);
        } else {
            holder.getSelected().setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return photos == null ? 0 : photos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView photo;
        private final ImageView selected;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            selected = (ImageView) itemView.findViewById(R.id.selected);
            itemView.setOnClickListener(this);
        }

        public ImageView getPhoto() {
            return photo;
        }

        public ImageView getSelected() {
            return selected;
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public String getItem(int position){
        return photos.get(position);
    }
    // allows clicks events to be caught
   public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
