package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Artist Class creates the object used to display the Artists list.
 */
public class Artist implements Serializable {

    private String mArtistName;
    private int mArtistSongsCount;
    private int mArtistAlbumsCount;
    private ArrayList<Song> mSongsByArtist = new ArrayList<>();

    /**
     * The Artist Object Constructor.
     * @param artistName The artist name.
     */
    public Artist(String artistName) {
        mArtistName = artistName;
    }

    /** Set the number of albums made by this artist. */
    public void setAlbumCount(int count) {
        if (mArtistAlbumsCount == 0) {
            mArtistAlbumsCount = count;
        }
    }

    /** Add songs that belong to this artist, to be displayed later in the ListActivity. */
    public void addSong(Song song) {
        if (!mSongsByArtist.contains(song)) {
            mSongsByArtist.add(song);
        }
        mArtistSongsCount = mSongsByArtist.size();
    }

    /** @return Returns the artist name. */
    public String getArtistName() {
        return mArtistName;
    }

    /** @return Returns the number of songs by this artist. */
    public int getArtistSongsCount() {
        return mArtistSongsCount;
    }

    /** @return Returns the number of albums by this artist. */
    public int getArtistAlbumsCount() {
        return mArtistAlbumsCount;
    }

    /** @return Returns a list of all songs by this artist. */
    public ArrayList<Song> getSongsByArtist() {
        return mSongsByArtist;
    }

    /**
     * Overrides the toString() method for debug purposes.
     * @return Returns a concatenated string with all the fields contents.
     */
    @Override
    public String toString() {
        return "Artist { " +
                "mArtistName='" + mArtistName + "', " +
                "mArtistSongsCount='" + mArtistSongsCount + "', " +
                "mArtistAlbumsCount='" + mArtistAlbumsCount + "', " +
                "mSongsByArtist=" + mSongsByArtist.toString() + " }";
    }
}
