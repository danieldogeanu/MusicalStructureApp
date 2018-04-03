package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsFragment extends Fragment {

    public AlbumsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Power", "The Aftertaste", "Feel the Sound Punch", "3:38", ""));
        songs.add(new Song("Twisted Love", "The Aftertaste", "Feel the Sound Punch", "4:28", ""));
        songs.add(new Song("Box Of Chocolates", "The Aftertaste", "Feel the Sound Punch", "3:28", ""));
        songs.add(new Song("When The Lights Go Out", "The Aftertaste", "Feel the Sound Punch", "3:32", ""));
        songs.add(new Song("Johnny", "The Aftertaste", "Feel the Sound Punch", "4:20", ""));
        songs.add(new Song("Adam & Eva", "The Aftertaste", "Feel the Sound Punch", "3:51", ""));
        songs.add(new Song("Power", "The Aftertaste", "Feel the Sound Punch", "3:38", ""));
        songs.add(new Song("Twisted Love", "The Aftertaste", "Feel the Sound Punch", "4:28", ""));
        songs.add(new Song("Box Of Chocolates", "The Aftertaste", "Feel the Sound Punch", "3:28", ""));
        songs.add(new Song("When The Lights Go Out", "The Aftertaste", "Feel the Sound Punch", "3:32", ""));
        songs.add(new Song("Johnny", "The Aftertaste", "Feel the Sound Punch", "4:20", ""));
        songs.add(new Song("Adam & Eva", "The Aftertaste", "Feel the Sound Punch", "3:51", ""));

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        AlbumAdapter adapter = new AlbumAdapter(getActivity(), songs, listView);
        listView.setAdapter(adapter);

        // TODO: Add setOnItemClickListener to handle item clicks in order to play music.
        // TODO: There are two kind of clicks that need to be handled: 1. On the item; to play music. 2. On the songDetails; to open Song Detail activity.
        // TODO: Add logic to show only one Album if there are multiple songs with the same Album.

        return rootView;
    }
}