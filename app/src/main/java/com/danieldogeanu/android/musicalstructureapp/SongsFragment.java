package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsFragment extends Fragment {

    public SongsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        Data data = Data.getInstance();
        ArrayList<Song> songs = data.getSongs();

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        SongAdapter adapter = new SongAdapter(getActivity(), songs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView songPlayingIcon = (ImageView) view.findViewById(R.id.songPlaying);
                Utils.toggleVisibility(songPlayingIcon);

            }
        });

        return rootView;
    }
}
