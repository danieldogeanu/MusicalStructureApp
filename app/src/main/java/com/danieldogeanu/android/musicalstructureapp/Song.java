package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;

/**
 * Song Class creates the object used to play music and to display necessary information.
 */
public class Song implements Serializable {

    private String mSongTitle;
    private String mSongArtist;
    private String mSongAlbum;
    private String mSongDuration;
    private String mSongAlbumArt = "";

    /**
     * Song Object Constructor. Takes 5 fields; all required;
     * @param songTitle The song title.
     * @param songArtist The artist of the song.
     * @param songAlbum The album that contains this song.
     * @param songDuration The length of the song.
     * @param songAlbumArt Album art associated with the song. This can be empty, but must be passed in the constructor regardless.
     */
    public Song(String songTitle, String songArtist, String songAlbum, String songDuration, String songAlbumArt) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDuration = songDuration;
        mSongAlbumArt = songAlbumArt;
    }

    /** @return Returns the song title. */
    public String getSongTitle() {
        return mSongTitle;
    }

    /** @return Returns the artist of the song. */
    public String getSongArtist() {
        return mSongArtist;
    }

    /** @return Returns the album name containing the song. */
    public String getSongAlbum() {
        return mSongAlbum;
    }

    /** @return Returns the song length. */
    public String getSongDuration() {
        return mSongDuration;
    }

    /** @return Returns the album art of the song, if it contains one. */
    public String getSongAlbumArt() {
        return mSongAlbumArt;
    }

    /** @return Returns true if there's an AlbumArt; false if AlbumArt is empty. */
    public boolean hasAlbumArt() {
        return !mSongAlbumArt.isEmpty();
    }

    /**
     * Overrides the toString() method for debug purposes.
     * @return Returns a concatenated string with all the fields contents.
     */
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
