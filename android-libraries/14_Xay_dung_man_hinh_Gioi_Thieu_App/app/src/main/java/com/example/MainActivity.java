package com.example;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getPaperOnboardingPageData());
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_frame, paperOnboardingFragment);
        fragmentTransaction.commit();

//        PaperOnboardingEngine engine =
//                new PaperOnboardingEngine(findViewById(com.ramotion.paperonboarding.R.id.onboardingRootView),
//                        getPaperOnboardingPageData(),
//                        this);
//        engine.setOnChangeListener((i, i1) -> Toast.makeText(MainActivity.this, "Swiped from " + i + " to " + i1, Toast.LENGTH_SHORT).show());
//        engine.setOnRightOutListener(() -> Toast.makeText(MainActivity.this, "Swiped out right ", Toast.LENGTH_SHORT).show());
//        engine.setOnLeftOutListener(() -> Toast.makeText(MainActivity.this, "Swiped out left ", Toast.LENGTH_SHORT).show());

    }

    private ArrayList<PaperOnboardingPage> getPaperOnboardingPageData() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Hotels",
                "All hotels and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.drawable.mot, R.drawable.hai);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Banks",
                "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0B4"), R.drawable.ba, R.drawable.bon);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Stores",
                "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.drawable.nam, R.drawable.sau);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        return elements;
    }
}