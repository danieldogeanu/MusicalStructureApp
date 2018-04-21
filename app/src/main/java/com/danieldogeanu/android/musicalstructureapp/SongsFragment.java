package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * SongsFragment is the Class that displays the Songs Tab in the Main Activity and also in the List Activity.
 */
public class SongsFragment extends Fragment {

    // Set global Fields to be available across the entire Class
    Data mData;
    ArrayList<Song> mSongs;
    MediaState mMediaState;
    ListView mListView;
    SongAdapter mAdapter;

    /** Empty SongsFragment Constructor. */
    public SongsFragment() {}

    /**
     * Overrides the onCreateView() method to assemble and display the Songs List.
     * @param inflater The layout inflater.
     * @param container The container view.
     * @param savedInstanceState The Bundle for the Saved Instance State.
     * @return Returns the assembled Songs List to display in the Songs Tab and also in the List Activity.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set the Root View and attach it to the Container
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get the Data and Media State for the Songs List
        mData = Data.getInstance();
        mSongs = mData.getSongs();
        mMediaState = MediaState.getInstance();

        // Populate the Songs ListView
        mListView = (ListView) rootView.findViewById(R.id.listView);
        mAdapter = new SongAdapter(getActivity(), mSongs, mMediaState);
        mListView.setAdapter(mAdapter);
        mAdapter.setNotifyOnChange(true);

        // Set the OnItemClickListener() to handle the item clicks
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the current Song
                Song song = mSongs.get(position);

                // Toggle the currently playing Song and the Song Playing Icon
                mMediaState.togglePlayingSong(song, view);

            }
        });

        // Return the fully assembled Songs ListView
        return rootView;
    }

    /**
     * Overrides the onResume() method in order to update data when users get back to the Main Activity.
     */
    @Override
    public void onResume() {
        super.onResume();

        // Update the state of the Songs in the ListView
        // We do this so that we know if the user clicked another Song in the
        // individual List Activities for each Album or Artist
        mAdapter = new SongAdapter(getActivity(), mSongs, mMediaState);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
