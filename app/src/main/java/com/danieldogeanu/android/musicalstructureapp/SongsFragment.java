package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * SongsFragment is the Class that displays the Songs Tab in the Main Activity and also in the List Activity.
 */
public class SongsFragment extends Fragment {

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

        // Get the Data for the Songs List
        Data data = Data.getInstance();
        ArrayList<Song> songs = data.getSongs();

        // Populate the Songs ListView
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        SongAdapter adapter = new SongAdapter(getActivity(), songs);
        listView.setAdapter(adapter);

        // Return the fully assembled Songs ListView
        return rootView;
    }
}
