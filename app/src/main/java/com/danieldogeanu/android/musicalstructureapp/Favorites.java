package com.danieldogeanu.android.musicalstructureapp;

import java.util.ArrayList;

/**
 * Singleton class that stores the Favorites list at a global level.
 */
public class Favorites {

    // Initialize the class Instance as soon as possible in order to be thread-safe.
    private static Favorites INSTANCE = new Favorites();

    // The global Favorites list.
    private ArrayList<Song> mFavorites = new ArrayList<>();

    /** Private Faveorites Constructor, so it can't be accessed from outside the class. */
    private Favorites() {}

    /** @return Always return the existing Instance of the class. */
    public static Favorites getInstance() {
        return(INSTANCE);
    }

    /**
     * Add the Song to the Favorites list, if there isn't already one.
     * @param song The Song to be added.
     */
    public void addSongToFavorites(Song song) {
        if ((song != null) && !isFavorite(song)) {
            mFavorites.add(song);
        }
    }

    /**
     * Find and remove the Song from the Favorites list, if there is one.
     * NOTE: We do it this way, because we get different object references when we exit and enter the activity again.
     * @param song The Song to be removed.
     */
    public void removeSongFromFavorites(Song song) {
        for (int i = 0; i < mFavorites.size(); i++) {
            Song currentSong = mFavorites.get(i);
            if (currentSong.getSongTitle().equals(song.getSongTitle())) {
                mFavorites.remove(i);
            }
        }
    }

    /**
     * Scan the Favorites list to see it the song is there or not.
     * NOTE: Again, we do it this way, because the objects don't match anymore.
     * @param song The Song we want to see if it's in the list.
     * @return Returns true if we find the Song, otherwise returns false.
     */
    public boolean isFavorite(Song song) {
        boolean favoriteState = false;
        for (int i = 0; i < mFavorites.size(); i++) {
            Song currentSong = mFavorites.get(i);
            if (currentSong.getSongTitle().equals(song.getSongTitle())) {
                favoriteState = true;
            }
        }
        return favoriteState;
    }

    /**
     * Overrides the toString() method for debug purposes.
     * @return Returns a concatenated string with all the Favorites list contents.
     */
    @Override
    public String toString() {
        return "Favorites { mFavorites=" + mFavorites + " }";
    }
}
