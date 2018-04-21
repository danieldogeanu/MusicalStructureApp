package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Album Class creates the object used to display the Albums list.
 */
public class Album implements Serializable {

    private String mAlbumName;
    private String mAlbumArtist;
    private ArrayList<Song> mSongsInAlbum = new ArrayList<>();

    /**
     * The Album Object Constructor.
     * @param albumName The album name.
     * @param albumArtist The artist of this album.
     */
    public Album(String albumName, String albumArtist) {
        mAlbumName = albumName;
        mAlbumArtist = albumArtist;
    }

    /** Add songs to this album, to be displayed later in the ListActivity. */
    public void addSong(Song song) {
        if (!mSongsInAlbum.contains(song)) {
            mSongsInAlbum.add(song);
        }
    }

    /** @return Returns the album name. */
    public String getAlbumName() {
        return mAlbumName;
    }

    /** @return Returns the album artist. */
    public String getAlbumArtist() {
        return mAlbumArtist;
    }

    /** @return Returns a list of all songs in the current album. */
    public ArrayList<Song> getSongsInAlbum() {
        return mSongsInAlbum;
    }

    /**
     * Overrides the toString() method for debug purposes.
     * @return Returns a concatenated string with all the fields contents.
     */
    @Override
    public String toString() {
        return "Album { " +
                "mAlbumName='" + mAlbumName + "', " +
                "mAlbumArtist='" + mAlbumArtist + "', " +
                "mSongsInAlbum=" + mSongsInAlbum.toString() + " }";
    }

}
