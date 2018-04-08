package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public static final String LOG_TAG = SongAdapter.class.getSimpleName();

    private ListView mSongListView;

    public SongAdapter(Activity context, ArrayList<Song> songs, ListView view) {
        super(context, 0, songs);
        mSongListView = view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        final Song currentSong = getItem(position);

        TextView songTitle = (TextView) listItemView.findViewById(R.id.songTitle);
        songTitle.setText(currentSong.getSongTitle());

        TextView songArtist = (TextView) listItemView.findViewById(R.id.songArtist);
        songArtist.setText(currentSong.getSongArtist());

        TextView songDuration = (TextView) listItemView.findViewById(R.id.songDuration);
        songDuration.setText(currentSong.getSongDuration());

        ImageButton songDetails = (ImageButton) listItemView.findViewById(R.id.songDetails);
        songDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(getContext(), DetailActivity.class);
                thisIntent.putExtra("song_data", currentSong);
                getContext().startActivity(thisIntent);
            }
        });

        return listItemView;
    }
}
