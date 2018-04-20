package com.danieldogeanu.android.musicalstructureapp;

import android.view.View;
import android.widget.ImageView;

public class MediaState {

    private static final MediaState INSTANCE = new MediaState();

    private Song currentSongPlaying = new Song("", "", "", "");

    private MediaState() {}

    static MediaState getInstance() {
        return(INSTANCE);
    }

    public Song getCurrentSongPlaying() {
        return currentSongPlaying;
    }

    public void togglePlayingSong(Song song, View view) {
        ImageView songPlayingIcon = (ImageView) view.findViewById(R.id.songPlaying);
        if ((currentSongPlaying != null) && !song.getSongTitle().equals(currentSongPlaying.getSongTitle())) {
            currentSongPlaying = song;
            songPlayingIcon.setVisibility(View.VISIBLE);
        } else {
            currentSongPlaying = new Song("", "", "", "");
            songPlayingIcon.setVisibility(View.GONE);
        }
    }

    public boolean isSongPlaying(Song song) {
        return ((currentSongPlaying != null) && song.getSongTitle().equals(currentSongPlaying.getSongTitle()));
    }

    // TODO: Add a way to have only one item active in the list at one time.

}
