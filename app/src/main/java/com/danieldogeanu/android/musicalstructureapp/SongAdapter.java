package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public static final String LOG_TAG = SongAdapter.class.getSimpleName();

    private MediaState mMediaState;

    public SongAdapter(Activity context, ArrayList<Song> songs, MediaState mediaState) {
        super(context, 0, songs);
        mMediaState = mediaState;
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

        ImageView songPlayingIcon = (ImageView) listItemView.findViewById(R.id.songPlaying);
        if (mMediaState.isSongPlaying(currentSong)) {
            songPlayingIcon.setVisibility(View.VISIBLE);
        }

        return listItemView;
    }
}
