package com.danieldogeanu.android.musicalstructureapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    private String[] tabTitles = new String[3];

    private Context mContext;

    public CategoryAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;

        tabTitles[0] = mContext.getString(R.string.cat_songs);
        tabTitles[1] = mContext.getString(R.string.cat_artists);
        tabTitles[2] = mContext.getString(R.string.cat_albums);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SongsFragment();
            case 1:
                return new ArtistsFragment();
            case 2:
                return new AlbumsFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
