package com.danieldogeanu.android.musicalstructureapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {

    private String mArtistName;
    private int mArtistSongsCount;
    private int mArtistAlbumsCount;
    private ArrayList<Song> mSongsByArtist = new ArrayList<>();

    public Artist(String artistName) {
        mArtistName = artistName;
    }

    public void setAlbumCount(int count) {
        if (mArtistAlbumsCount == 0) {
            mArtistAlbumsCount = count;
        }
    }

    public void addSong(Song song) {
        if (!mSongsByArtist.contains(song)) {
            mSongsByArtist.add(song);
        }
        mArtistSongsCount = mSongsByArtist.size();
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getArtistSongsCount() {
        return mArtistSongsCount;
    }

    public int getArtistAlbumsCount() {
        return mArtistAlbumsCount;
    }

    public ArrayList<Song> getSongsByArtist() {
        return mSongsByArtist;
    }

    @Override
    public String toString() {
        return "Artist { " +
                "mArtistName='" + mArtistName + "', " +
                "mArtistSongsCount='" + mArtistSongsCount + "', " +
                "mArtistAlbumsCount='" + mArtistAlbumsCount + "', " +
                "mSongsByArtist=" + mSongsByArtist.toString() + " }";
    }
}
