package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(adapter);
        viewPager.setVisibility(View.VISIBLE);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        LinearLayout emptyList = (LinearLayout) findViewById(R.id.emptyList);
        emptyList.setVisibility(View.GONE);

    }
}
