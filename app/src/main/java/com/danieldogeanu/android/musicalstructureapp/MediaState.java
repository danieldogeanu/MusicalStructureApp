package com.danieldogeanu.android.musicalstructureapp;

import android.view.View;
import android.widget.ImageView;

public class MediaState {

    private static final MediaState INSTANCE = new MediaState();

    private Song currentSongPlaying = new Song("", "", "", "");
    private View currentView = null;

    private MediaState() {}

    static MediaState getInstance() {
        return(INSTANCE);
    }

    public void togglePlayingSong(Song song, View newView) {
        ImageView oldPlayingIcon = null;
        if (currentView != null) {
            oldPlayingIcon = (ImageView) currentView.findViewById(R.id.songPlaying);
        }
        ImageView newPlayingIcon = (ImageView) newView.findViewById(R.id.songPlaying);

        if ((currentSongPlaying != null) && !song.getSongTitle().equals(currentSongPlaying.getSongTitle())) {
            currentSongPlaying = song;
            if (currentView == null) {
                newPlayingIcon.setVisibility(View.VISIBLE);
                currentView = newView;
            } else if ((currentView != null) && (currentView != newView)) {
                if (oldPlayingIcon != null) oldPlayingIcon.setVisibility(View.GONE);
                newPlayingIcon.setVisibility(View.VISIBLE);
                currentView = newView;
            }
        } else if ((currentSongPlaying != null) && song.getSongTitle().equals(currentSongPlaying.getSongTitle())) {
            if ((currentView != null) && (currentView != newView)) {
                if (oldPlayingIcon != null) oldPlayingIcon.setVisibility(View.GONE);
                newPlayingIcon.setVisibility(View.VISIBLE);
                currentView = newView;
            } else if ((currentView != null) && (currentView == newView)) {
                newPlayingIcon.setVisibility(View.GONE);
                currentView = null;
            }
        } else {
            currentSongPlaying = new Song("", "", "", "");
            if (oldPlayingIcon != null) oldPlayingIcon.setVisibility(View.GONE);
            newPlayingIcon.setVisibility(View.GONE);
            currentView = null;
        }
    }

    public boolean isSongPlaying(Song song) {
        return ((currentSongPlaying != null) && song.getSongTitle().equals(currentSongPlaying.getSongTitle()));
    }

}
