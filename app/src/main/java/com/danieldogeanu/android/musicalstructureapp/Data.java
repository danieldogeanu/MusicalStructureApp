package com.danieldogeanu.android.musicalstructureapp;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.util.Log;

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
        if (!mFilePaths.isEmpty()) extractFilesMetadata(mFilePaths);

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
                        if (file.isFile()) {
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

        for (int i = 0; i < filePaths.size(); i++) {
            String thisFilePath = filePaths.get(i);

            try {
                mediaMetadataRetriever.setDataSource(thisFilePath);

                songTitle = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                songArtist = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                songAlbum = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
                rawDuration = Long.valueOf(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
                songDuration = (new SimpleDateFormat("m:ss", Locale.US)).format(new Date(rawDuration));

                if (songTitle == null) songTitle = "Untitled";
                if (songArtist == null) songArtist = "Unknown Artist";
                if (songAlbum == null) songAlbum = "Unknown Album";
                if (songDuration == null) songDuration = "0:00";

                mSongs.add(new Song(songTitle, songArtist, songAlbum, songDuration, ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mediaMetadataRetriever.release();
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
