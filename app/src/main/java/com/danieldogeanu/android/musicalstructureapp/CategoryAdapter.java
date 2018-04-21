package com.danieldogeanu.android.musicalstructureapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * The CategoryAdapter Class creates the Tabs for the ViewPager in the Main Activity.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    // Set the number of pages and initiate the Tab Titles Array
    private final int PAGE_COUNT = 3;
    private String[] tabTitles = new String[PAGE_COUNT];

    private Context mContext;

    /**
     * The CategoryAdapter Constructor. Takes 2 parameters.
     * @param fragmentManager The FragmentManager.
     * @param context The Context.
     */
    public CategoryAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;

        // Set Tab Titles
        tabTitles[0] = mContext.getString(R.string.cat_songs);
        tabTitles[1] = mContext.getString(R.string.cat_artists);
        tabTitles[2] = mContext.getString(R.string.cat_albums);
    }

    /** @return Returns the number of pages. */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /** @return Returns the Fragment associated with specific page. */
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

    /** @return Returns the Tab Title at certain position. */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
