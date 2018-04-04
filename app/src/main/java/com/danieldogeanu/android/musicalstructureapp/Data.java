package com.danieldogeanu.android.musicalstructureapp;

import java.util.ArrayList;

public class Data {

    private ArrayList<Song> mSongs = new ArrayList<>();

    public Data() {
        mSongs.add(new Song("Power", "The Aftertaste", "Feel the Sound Punch", "3:38", ""));
        mSongs.add(new Song("Twisted Love", "The Aftertaste", "Feel the Sound Punch", "4:28", ""));
        mSongs.add(new Song("Box Of Chocolates", "The Aftertaste", "Feel the Sound Punch", "3:28", ""));
        mSongs.add(new Song("When The Lights Go Out", "The Aftertaste", "Feel the Sound Punch", "3:32", ""));
        mSongs.add(new Song("Johnny", "The Aftertaste", "Feel the Sound Punch", "4:20", ""));
        mSongs.add(new Song("Adam & Eva", "The Aftertaste", "Feel the Sound Punch", "3:51", ""));
        mSongs.add(new Song("Power", "The Aftertaste", "Feel the Sound Punch", "3:38", ""));
        mSongs.add(new Song("Twisted Love", "The Aftertaste", "Feel the Sound Punch", "4:28", ""));
        mSongs.add(new Song("Box Of Chocolates", "The Aftertaste", "Feel the Sound Punch", "3:28", ""));
        mSongs.add(new Song("When The Lights Go Out", "The Aftertaste", "Feel the Sound Punch", "3:32", ""));
        mSongs.add(new Song("Johnny", "The Aftertaste", "Feel the Sound Punch", "4:20", ""));
        mSongs.add(new Song("Adam & Eva", "The Aftertaste", "Feel the Sound Punch", "3:51", ""));
    }

    public ArrayList<Song> getSongs() {
        return mSongs;
    }

}
