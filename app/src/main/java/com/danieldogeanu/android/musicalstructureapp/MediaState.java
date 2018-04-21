package com.danieldogeanu.android.musicalstructureapp;

import android.view.View;
import android.widget.ImageView;

/**
 * Singleton class that keeps the state of currently 'playing' Song.
 * NOTE: This class momentary just keeps track of the currently selected Song and not
 * actually of the 'playing' state of it, as the Song object it's not an audio file yet.
 */
public class MediaState {

    // Initialize the class Instance as soon as possible in order to be thread-safe.
    private static final MediaState INSTANCE = new MediaState();

    // Initialize the current Song with an empty Song object.
    private Song currentSongPlaying = new Song("", "", "", "");
    // Keep the past views selected, so we can turn them off once we click on new views.
    private View currentView = null;

    /** Private MediaState Constructor, so it can't be accessed from outside the class. */
    private MediaState() {}

    /** @return Always return the existing Instance of the class. */
    static MediaState getInstance() {
        return(INSTANCE);
    }

    /**
     * Toggle the Playing Song state. This method adds the Song as the currently 'playing'
     * if there isn't one already. There can be only one currently 'playing' Song.
     * This method also toggles the Song Playing Icon in the Item View, on or off,
     * depending on the state of the currently 'playing' Song.
     * @param song The song to be toggled.
     * @param newView The view from which this method is called. This is required so that we can toggle the icon.
     */
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

    /** @return Returns true if the Song is equal to the currently 'playing' Song, or false if it's not. */
    public boolean isSongPlaying(Song song) {
        return ((currentSongPlaying != null) && song.getSongTitle().equals(currentSongPlaying.getSongTitle()));
    }

}
