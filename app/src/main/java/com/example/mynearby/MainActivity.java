package com.example.mynearby;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 storeImageSlider;
    private TabLayout tabDots;
    private Handler sliderHandler;
    private Runnable sliderRunnable;
    private int currentPage = 0; // To keep track of the current page
    private List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeImageSlider = findViewById(R.id.storeImageSlider);
        tabDots = findViewById(R.id.tabDots);

        // List of image resource IDs
        imageList = new ArrayList<>();
        imageList.add(R.drawable.shop1);
        imageList.add(R.drawable.shop2);
        imageList.add(R.drawable.shop3);

        SliderAdapter adapter = new SliderAdapter(imageList);
        storeImageSlider.setAdapter(adapter);

        // Setup TabLayout with ViewPager2
        new TabLayoutMediator(tabDots, storeImageSlider, (tab, position) -> tab.setIcon(R.drawable.ic_dot))
                .attach();

        // Set up auto-sliding
        setupAutoSlider();
    }

    private void setupAutoSlider() {
        sliderHandler = new Handler(Looper.getMainLooper());
        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                // Increment current page
                currentPage = (currentPage + 1) % imageList.size(); // Looping through images
                storeImageSlider.setCurrentItem(currentPage, true); // Smooth transition
                sliderHandler.postDelayed(this, 3000); // Change image every 3 seconds
            }
        };
        sliderHandler.postDelayed(sliderRunnable, 3000); // Start auto sliding after 3 seconds
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sliderHandler.removeCallbacks(sliderRunnable); // Stop auto sliding when activity is destroyed
    }
}
