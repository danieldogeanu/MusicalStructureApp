package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsFragment extends Fragment {

    public ArtistsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        Data data = new Data();
        ArrayList<Artist> artists = data.getArtists();

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        ArtistAdapter adapter = new ArtistAdapter(getActivity(), artists, listView);
        listView.setAdapter(adapter);

        // TODO: Add setOnItemClickListener to handle item clicks in order to play music.
        // TODO: There are two kind of clicks that need to be handled: 1. On the item; to play music. 2. On the songDetails; to open Song Detail activity.

        return rootView;
    }
}
