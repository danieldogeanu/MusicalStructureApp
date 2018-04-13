package com.danieldogeanu.android.musicalstructureapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Data {

    private static Data INSTANCE = new Data();

    private ArrayList<String> mFilePaths = new ArrayList<>();
    private ArrayList<Song> mSongs = new ArrayList<>();
    private ArrayList<Artist> mArtists = new ArrayList<>();
    private ArrayList<Album> mAlbums = new ArrayList<>();

    private Data() {
        getFilePaths("Music", false);

        if (!mFilePaths.isEmpty()) {
            extractFilesMetadata(mFilePaths);
        } else {
            loadDemoData();
        }

        if (!mSongs.isEmpty()) sortAlbums(mSongs);
        if (!mSongs.isEmpty()) sortArtists(mSongs);
    }

    public static Data getInstance() {
        return(INSTANCE);
    }

    private void sortAlbums(ArrayList<Song> songs) {
        ArrayList<String> existingAlbums = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            Album thisAlbum = new Album(song.getSongAlbum(), song.getSongArtist());
            String thisAlbumName = thisAlbum.getAlbumName();

            if (!existingAlbums.contains(thisAlbumName)) {
                thisAlbum.addSong(song);
                mAlbums.add(thisAlbum);
                existingAlbums.add(thisAlbumName);
            } else {
                for (int a = 0; a < mAlbums.size(); a++) {
                    Album existingAlbum = mAlbums.get(a);
                    String existingAlbumName = existingAlbum.getAlbumName();
                    if (existingAlbumName.equals(thisAlbumName)) {
                        existingAlbum.addSong(song);
                    }
                }
            }
        }
    }

    private void sortArtists(ArrayList<Song> songs) {
        ArrayList<String> existingArtists = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            Artist thisArtist = new Artist(song.getSongArtist());
            String thisArtistName = thisArtist.getArtistName();

            if (!existingArtists.contains(thisArtistName)) {
                thisArtist.addSong(song);
                int thisArtistAlbumsNo = getAlbumCount(song.getSongArtist());
                thisArtist.setAlbumCount(thisArtistAlbumsNo);
                mArtists.add(thisArtist);
                existingArtists.add(thisArtistName);
            } else {
                for (int a = 0; a < mArtists.size(); a++) {
                    Artist existingArtist = mArtists.get(a);
                    String existingArtistName = existingArtist.getArtistName();
                    if (existingArtistName.equals(thisArtistName)) {
                        existingArtist.addSong(song);
                    }
                }
            }
        }
    }

    private int getAlbumCount(String artistName) {
        int albumCount = 0;
        for (int i = 0; i < mAlbums.size(); i++) {
            Album thisAlbum = mAlbums.get(i);
            if (thisAlbum.getAlbumArtist().equals(artistName)) {
                albumCount++;
            }
        }
        return albumCount;
    }

    private void getFilePaths(String directoryName, boolean isPath) {
        try {
            File directory = null;
            if (!directoryName.isEmpty() && !isPath) {
                File sdCard = Environment.getExternalStorageDirectory();
                directory = new File(sdCard.getAbsolutePath() + "/" + directoryName);
            }
            if (!directoryName.isEmpty() && isPath) {
                directory = new File(directoryName);
            }
            if (directory != null && directory.exists()) {
                File[] filesList = directory.listFiles();
                if (filesList != null) {
                    for (File file : filesList) {
                        if (file.isFile() && file.getPath().endsWith(".mp3")) {
                            mFilePaths.add(file.getAbsolutePath());
                        } else if (file.isDirectory()) {
                            getFilePaths(file.getAbsolutePath(), true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extractFilesMetadata(ArrayList<String> filePaths) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String songTitle, songArtist, songAlbum, songDuration;
        long rawDuration;
        byte[] rawAlbumArt;
        Bitmap songAlbumArt = null;
        ProxyBitmap proxyAlbumArt = null;

        for (int i = 0; i < filePaths.size(); i++) {
            String thisFilePath = filePaths.get(i);

            try {
                mediaMetadataRetriever.setDataSource(thisFilePath);

                songTitle = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                songArtist = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                songAlbum = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
                rawDuration = Long.valueOf(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
                rawAlbumArt = mediaMetadataRetriever.getEmbeddedPicture();

                songDuration = (new SimpleDateFormat("m:ss", Locale.US)).format(new Date(rawDuration));
                if (rawAlbumArt != null) {
                    songAlbumArt = BitmapFactory.decodeByteArray(rawAlbumArt, 0, rawAlbumArt.length);
                    proxyAlbumArt = new ProxyBitmap(songAlbumArt); // Made Bitmap Serializable
                }

                if (songTitle == null) songTitle = "Untitled";
                if (songArtist == null) songArtist = "Unknown Artist";
                if (songAlbum == null) songAlbum = "Unknown Album";
                if (songDuration == null) songDuration = "0:00";

                if (songAlbumArt != null) {
                    mSongs.add(new Song(songTitle, songArtist, songAlbum, songDuration, proxyAlbumArt));
                } else {
                    mSongs.add(new Song(songTitle, songArtist, songAlbum, songDuration));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mediaMetadataRetriever.release();
    }

    private void loadDemoData() {
        mSongs.add(new Song("Power", "The Aftertaste", "Feel the Sound Punch", "3:38"));
        mSongs.add(new Song("Twisted Love", "The Aftertaste", "Feel the Sound Punch", "4:28"));
        mSongs.add(new Song("Box Of Chocolates", "The Aftertaste", "Feel the Sound Punch", "3:28"));
        mSongs.add(new Song("When The Lights Go Out", "The Aftertaste", "Feel the Sound Punch", "3:32"));
        mSongs.add(new Song("Johnny", "The Aftertaste", "Feel the Sound Punch", "4:20"));
        mSongs.add(new Song("Adam & Eva", "The Aftertaste", "Feel the Sound Punch", "3:51"));

        mSongs.add(new Song("Somebody Special", "Nina Nesbitt", "Somebody Special", "3:19"));
        mSongs.add(new Song("Sunburn", "Droeloe", "Sunburn", "3:47"));
        mSongs.add(new Song("Sit Next to Me", "Foster The People", "Sit Next to Me", "4:03"));
        mSongs.add(new Song("Plot Twist", "Sigrid", "Plot Twist", "3:25"));
        mSongs.add(new Song("OT", "John.K", "OT", "3:12"));
        mSongs.add(new Song("Takes My Body Higher (feat. Lincoln Jesser)", "Shoffy, Lincoln Jesser", "Conversations in the A.M.", "4:12"));

        mSongs.add(new Song("Bad At Love", "Halsey", "Hopeless Fountain Kingdom", "3:01"));
        mSongs.add(new Song("Control", "Halsey", "Badlands", "3:35"));
        mSongs.add(new Song("Gasoline", "Halsey", "Badlands", "3:20"));
        mSongs.add(new Song("Castle", "Halsey", "Badlands", "4:38"));
    }

    public ArrayList<Song> getSongs() {
        return mSongs;
    }

    public ArrayList<Artist> getArtists() {
        return mArtists;
    }

    public ArrayList<Album> getAlbums() {
        return mAlbums;
    }

}
