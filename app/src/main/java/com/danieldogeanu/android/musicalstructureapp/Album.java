package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {

    private String mAlbumName;
    private String mAlbumArtist;
    private ArrayList<Song> mSongsInAlbum = new ArrayList<>();

    public Album(String albumName, String albumArtist) {
        mAlbumName = albumName;
        mAlbumArtist = albumArtist;
    }

    public void addSong(Song song) {
        if (!mSongsInAlbum.contains(song)) {
            mSongsInAlbum.add(song);
        }
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getAlbumArtist() {
        return mAlbumArtist;
    }

    public ArrayList<Song> getSongsInAlbum() {
        return mSongsInAlbum;
    }

    @Override
    public String toString() {
        return "Album { " +
                "mAlbumName='" + mAlbumName + "', " +
                "mAlbumArtist='" + mAlbumArtist + "', " +
                "mSongsInAlbum=" + mSongsInAlbum.toString() + " }";
    }

}
