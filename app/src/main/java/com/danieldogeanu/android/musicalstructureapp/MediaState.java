package com.danieldogeanu.android.musicalstructureapp;

import java.util.ArrayList;

public class MediaState {

    private static MediaState INSTANCE = new MediaState();

    private ArrayList<Song> mCurrentPlaylist = new ArrayList<>();
    private ArrayList<Song> mPreviousPlaylist = new ArrayList<>();

    private Song mPreviousSong = null;
    private Song mCurrentSong = null;
    private Song mNextSong = null;

    private boolean mIsPlaying = false;
    private boolean mIsShuffle = false;
    private boolean mIsRepeat = false;

    private MediaState() {}

    public static MediaState getInstance() {
        return(INSTANCE);
    }

    public Song getPreviousSong() {
        return mPreviousSong;
    }

    public Song getCurrentSong() {
        return mCurrentSong;
    }

    public Song getNextSong() {
        return mNextSong;
    }

    public void setPreviousSong(Song song) {
        mPreviousSong = song;
    }

    public void setCurrentSong(Song song) {
        mCurrentSong = song;
    }

    public void setNextSong(Song song) {
        mNextSong = song;
    }

    public boolean isPlaying() {
        return mIsPlaying;
    }

    public void setPlayingOn() {
        mIsPlaying = true;
    }

    public void setPlayingOff() {
        mIsPlaying = false;
    }

    public boolean isShuffle() {
        return mIsShuffle;
    }

    public void setShuffleOn() {
        mIsShuffle = true;
    }

    public void setShuffleOff() {
        mIsShuffle = false;
    }

    public boolean isRepeat() {
        return mIsRepeat;
    }

    public void setRepeatOn() {
        mIsRepeat = true;
    }

    public void setRepeatOff() {
        mIsRepeat = false;
    }

}
