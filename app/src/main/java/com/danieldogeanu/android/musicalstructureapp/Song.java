package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;

public class Song implements Serializable {

    private String mSongTitle;
    private String mSongArtist;
    private String mSongAlbum;
    private String mSongDuration;
    private String mSongAlbumArt;

    public Song(String songTitle, String songArtist, String songAlbum, String songDuration, String songAlbumArt) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDuration = songDuration;
        mSongAlbumArt = songAlbumArt;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongAlbum() {
        return mSongAlbum;
    }

    public String getSongDuration() {
        return mSongDuration;
    }

    public String getSongAlbumArt() {
        return mSongAlbumArt;
    }

    @Override
    public String toString() {
        return "Song { " +
                "mSongTitle='" + mSongTitle + "', " +
                "mSongArtist='" + mSongArtist + "', " +
                "mSongAlbum='" + mSongAlbum + "', " +
                "mSongDuration='" + mSongDuration + "', " +
                "mSongAlbumArt='" + mSongAlbumArt + "' }";
    }

}
