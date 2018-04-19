package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public static final String LOG_TAG = SongAdapter.class.getSimpleName();

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        final Song currentSong = getItem(position);

        Utils.setTextToView(listItemView, R.id.songTitle, currentSong.getSongTitle());
        Utils.setTextToView(listItemView, R.id.songArtist, currentSong.getSongArtist());
        Utils.setTextToView(listItemView, R.id.songDuration, currentSong.getSongDuration());

        Utils.addDetailsButtonIntent(listItemView, R.id.songDetails, DetailActivity.class, "song_data", currentSong);

        return listItemView;
    }
}
