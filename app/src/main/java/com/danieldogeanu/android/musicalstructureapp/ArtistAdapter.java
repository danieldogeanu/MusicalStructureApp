package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Song> {

    public static final String LOG_TAG = ArtistAdapter.class.getSimpleName();

    private ListView mSongListView;

    public ArtistAdapter(Activity context, ArrayList<Song> songs, ListView view) {
        super(context, 0, songs);
        mSongListView = view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.artist_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView artistName = (TextView) listItemView.findViewById(R.id.artistName);
        artistName.setText(currentSong.getSongArtist());

        TextView artistData = (TextView) listItemView.findViewById(R.id.artistData);
        artistData.setText("6 Songs \u2014 1 Album");

        // TODO: Create logic to get artist data.
        // TODO: Add a way to open Artist List activity.

        return listItemView;
    }
}
