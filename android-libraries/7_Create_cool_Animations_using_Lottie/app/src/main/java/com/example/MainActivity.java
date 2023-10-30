package com.example;

import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.animation_view);
        lottieAnimationView.playAnimation();
        lottieAnimationView.setAnimation("loading.json");
        lottieAnimationView.setRepeatCount(ValueAnimator.INFINITE);
    }
}