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
    private String mSongFilePath;
    private String mSongAlbumArt;

    /**
     * The Song Object Constructor used for the cases where there's no Album Art.
     * @param songTitle The song title.
     * @param songArtist The artist of the song.
     * @param songAlbum The album that contains this song.
     * @param songDuration The length of the song.
     * @param songFilePath The file path to this song.
     */
    public Song(String songTitle, String songArtist, String songAlbum, String songDuration, String songFilePath) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDuration = songDuration;
        mSongFilePath = songFilePath;
    }

    /**
     * The Song Object Constructor used for the cases where there's an Album Art.
     * @param songTitle The song title.
     * @param songArtist The artist of the song.
     * @param songAlbum The album that contains this song.
     * @param songDuration The length of the song.
     * @param songFilePath The file path to this song.
     * @param songAlbumArt The file path of the Album Art associated with the song.
     */
    public Song(String songTitle, String songArtist, String songAlbum, String songDuration, String songFilePath, String songAlbumArt) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDuration = songDuration;
        mSongFilePath = songFilePath;
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
    public String getSongAlbumArt() {
        return mSongAlbumArt;
    }

    /** @return Returns the MP3 file path for the Song. */
    public String getSongFilePath() {
        return mSongFilePath;
    }

    /** @return Returns true if there's an AlbumArt; false if AlbumArt is empty. */
    public boolean hasAlbumArt() {
        return (!mSongAlbumArt.isEmpty());
    }

    /** @return Returns true if there's a file path to the MP3 file. */
    public boolean hasFilePath() {
        return (!mSongFilePath.isEmpty());
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
