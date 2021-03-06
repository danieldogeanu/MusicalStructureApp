package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;

/**
 * Song Class creates the object used to play music and to display necessary information.
 */
public class Song implements Serializable {

    private static final int NO_IMAGE_RESOURCE = -1;

    private String mSongTitle;
    private String mSongArtist;
    private String mSongAlbum;
    private String mSongDuration;
    private int mSongAlbumArt = NO_IMAGE_RESOURCE;

    /**
     * The Song Object Constructor used for the cases where there's no Album Art.
     * @param songTitle The song title.
     * @param songArtist The artist of the song.
     * @param songAlbum The album that contains this song.
     * @param songDuration The length of the song.
     */
    public Song(String songTitle, String songArtist, String songAlbum, String songDuration) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDuration = songDuration;
    }

    /**
     * The Song Object Constructor used for the cases where there's an Album Art.
     * @param songTitle The song title.
     * @param songArtist The artist of the song.
     * @param songAlbum The album that contains this song.
     * @param songDuration The length of the song.
     * @param songAlbumArt The resource ID of the Album Art associated with the song.
     */
    public Song(String songTitle, String songArtist, String songAlbum, String songDuration, int songAlbumArt) {
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

    /** @return Returns the file path of the Album Art for the Song. */
    public int getSongAlbumArt() {
        return mSongAlbumArt;
    }

    /** @return Returns true if there's an AlbumArt; false if AlbumArt is empty. */
    public boolean hasAlbumArt() {
        return (mSongAlbumArt != NO_IMAGE_RESOURCE);
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
