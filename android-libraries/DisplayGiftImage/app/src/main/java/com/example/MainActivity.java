package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private static final String URL_GIF_IMAGE = "https://i.imgur.com/Vth6CBz.gif";

    @BindView(R.id.img_gif_2)
    public GifImageView imageView2;
    @BindView(R.id.img_gif)
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageView2.setImageResource(R.drawable.giphy);

        Glide.with(this).load(URL_GIF_IMAGE).into(imageView);
        final MediaController mc = new MediaController(this);
        mc.setMediaPlayer((GifDrawable) imageView2.getDrawable());
        mc.setAnchorView(imageView2);
        imageView2.setOnClickListener(v -> mc.show());
    }
}