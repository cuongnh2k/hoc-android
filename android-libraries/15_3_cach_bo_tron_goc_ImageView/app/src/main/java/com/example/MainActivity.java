package com.example;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgGlide = findViewById(R.id.img_glide);
        Glide.with(this)
                .load(R.drawable.image1)
                .apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(1)))
                .into(imgGlide);
    }
}