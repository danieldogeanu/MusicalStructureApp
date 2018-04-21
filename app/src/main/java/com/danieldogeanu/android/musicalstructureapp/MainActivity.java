package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Class that initializes the Main Activity for the app.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiate the ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(adapter);
        viewPager.setVisibility(View.VISIBLE);

        // Set Tab Titles and associate them with the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Hide the EmptyList placeholder View
        LinearLayout emptyList = (LinearLayout) findViewById(R.id.emptyList);
        emptyList.setVisibility(View.GONE);

    }
}
