package com.danieldogeanu.android.musicalstructureapp;

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

    public void setPlayingSong(Song song) {
        if ((currentSongPlaying != null) && !song.getSongTitle().equals(currentSongPlaying.getSongTitle())) {
            currentSongPlaying = song;
        } else {
            currentSongPlaying = new Song("", "", "", "");
        }
    }

    public boolean isSongPlaying(Song song) {
        return ((currentSongPlaying != null) && song.getSongTitle().equals(currentSongPlaying.getSongTitle()));
    }

    // TODO: Add a way to broadcast state change so that the SongAdapter knows when to trigger an update for the SongsFragment.
    // TODO: Add a way to have only one item active in the list at one time.

}
