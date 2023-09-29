package com.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private Context mContext;
    private ArrayList<Uri> mListPhotos;

    public PhotoAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<Uri> list) {
        this.mListPhotos = list;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Uri uri = mListPhotos.get(position);
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);
            holder.imagePhoto.setImageBitmap(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        return mListPhotos == null ? 0 : mListPhotos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagePhoto;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            this.imagePhoto = itemView.findViewById(R.id.image_view);
        }
    }
}
