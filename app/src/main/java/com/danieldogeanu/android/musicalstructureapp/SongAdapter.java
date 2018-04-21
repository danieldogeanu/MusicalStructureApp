package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * SongAdapter is a custom ArrayAdapter for the Song objects.
 * It's used to build the list of items to display in the Songs Tab
 * and also in the ListActivity associated with each Artist or Album.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    private MediaState mMediaState;

    /**
     * SongAdapter Constructor. Accepts 3 parameters.
     * @param context The Activity on which this adapter will run.
     * @param songs The ArrayList with all the songs.
     * @param mediaState The MediaState instance, to keep track of currently playing song.
     */
    public SongAdapter(Activity context, ArrayList<Song> songs, MediaState mediaState) {
        super(context, 0, songs);
        mMediaState = mediaState;
    }

    /**
     * Overrides the getView() method to display a custom layout for each item in the ListView.
     * @param position The position in the ListView.
     * @param convertView The view for the Item in the ListView.
     * @param parent The parent view.
     * @return Returns the assembled Item to display in the ListView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get or inflate the Song Item View
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        // Get current Song object from the ArrayList
        final Song currentSong = getItem(position);

        // Set the Song Title, Artist and Duration
        Utils.setTextToView(listItemView, R.id.songTitle, currentSong.getSongTitle());
        Utils.setTextToView(listItemView, R.id.songArtist, currentSong.getSongArtist());
        Utils.setTextToView(listItemView, R.id.songDuration, currentSong.getSongDuration());

        // Attach intent to the Song Details Button to open the Detail Activity
        Utils.addDetailsButtonIntent(listItemView, R.id.songDetails, DetailActivity.class, "song_data", currentSong);

        // See if this Song is currently playing and display the Song Playing Icon
        if (mMediaState.isSongPlaying(currentSong)) mMediaState.togglePlayingSong(currentSong, listItemView);

        // Return the fully assembled Song Item
        return listItemView;
    }
}
