package com.cookandroid.test20210623;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("1번"));
        tabLayout.addTab(tabLayout.newTab().setText("2번"));
        tabLayout.addTab(tabLayout.newTab().setText("3번"));
        tabLayout.addTab(tabLayout.newTab().setText("4번"));

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }

        });

    }
}