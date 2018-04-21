package com.danieldogeanu.android.musicalstructureapp;

import java.util.ArrayList;

/**
 * Singleton class that is responsible for populating and providing data for the entire app.
 */
public class Data {

    // Initialize the class Instance as soon as possible in order to be thread-safe.
    private static Data INSTANCE = new Data();

    // Data holders
    private ArrayList<Song> mSongs;
    private ArrayList<Artist> mArtists;
    private ArrayList<Album> mAlbums;

    /**
     * Private Constructor for the Data Class.
     * Since this is a Singleton, we don't need to be able to instantiate the Class via constructor.
     * We already instantiated it once, above.
     * This is required so that we can keep state across all Activities in the app.
     */
    private Data() {
        // Initiate data holders
        mSongs = new ArrayList<>();
        mArtists = new ArrayList<>();
        mAlbums = new ArrayList<>();

        // Populate the app with data
        loadData();

        // Sort Songs by Albums and Artists
        if (!mSongs.isEmpty()) {
            extractAlbums();
            extractArtists();
        }
    }

    /** @return Always return the existing Instance of the class. */
    public static Data getInstance() {
        return(INSTANCE);
    }

    /** Method to populate the app with demo data. */
    private void loadData() {
        mSongs.add(new Song("Done with Disco", "Art of Escapism", "Wild Card", "3:10", R.drawable.wildcard));
        mSongs.add(new Song("Eight Cat", "Art of Escapism", "Wild Card", "3:15", R.drawable.wildcard));
        mSongs.add(new Song("Little by Little", "Art of Escapism", "Wild Card", "1:50", R.drawable.wildcard));
        mSongs.add(new Song("Out on Our Own", "Art of Escapism", "Wild Card", "3:16", R.drawable.wildcard));
        mSongs.add(new Song("Rahjan", "Art of Escapism", "Wild Card", "1:55", R.drawable.wildcard));
        mSongs.add(new Song("Start Over", "Art of Escapism", "Wild Card", "3:12", R.drawable.wildcard));
        mSongs.add(new Song("Awestruck", "Cellophane Sam", "Sea Change", "3:58", R.drawable.seachange));
        mSongs.add(new Song("Deluge", "Cellophane Sam", "Sea Change", "3:51", R.drawable.seachange));
        mSongs.add(new Song("Early Breath", "Cellophane Sam", "Sea Change", "3:03", R.drawable.seachange));
        mSongs.add(new Song("Mountains", "Cellophane Sam", "Sea Change", "2:19", R.drawable.seachange));
        mSongs.add(new Song("The Turnaround Road", "Cellophane Sam", "Sea Change", "3:05", R.drawable.seachange));
        mSongs.add(new Song("While Looking Up", "Cellophane Sam", "Sea Change", "3:21", R.drawable.seachange));
        mSongs.add(new Song("Lifeless Worlds", "DASK", "Abiogenesis", "3:20", R.drawable.abiogenesis));
        mSongs.add(new Song("Mass Forming", "DASK", "Abiogenesis", "7:12", R.drawable.abiogenesis));
        mSongs.add(new Song("Junk Vultures", "Exquisite Frosting Penmanship", "Transistor Rodeo", "2:08", R.drawable.transistorrodeo));
        mSongs.add(new Song("Lightbringer", "Magna Ingress", "Aeon 3: Memoriae", "3:27", R.drawable.aeon3memoriae));
        mSongs.add(new Song("Nuts and Bolts", "Monkey Warhol", "Hannah Banana", "3:27", R.drawable.hannahbanana));
        mSongs.add(new Song("Stolen Moments", "Monkey Warhol", "Hannah Banana", "2:59", R.drawable.hannahbanana));
        mSongs.add(new Song("Times of Your Life", "Monkey Warhol", "Hannah Banana", "3:32", R.drawable.hannahbanana));
        mSongs.add(new Song("Wavy Glass", "Podington Bear", "Meet Podington Bear", "3:16", R.drawable.meetpodingtonbear));
        mSongs.add(new Song("Wonder Happens", "Podington Bear", "Meet Podington Bear", "3:08", R.drawable.meetpodingtonbear));
        mSongs.add(new Song("Otter", "Qusic", "Up", "2:32", R.drawable.up));
        mSongs.add(new Song("Being", "Ryan Andersen", "Solitude", "2:24", R.drawable.solitude));
        mSongs.add(new Song("Love, Love, Love", "Ryan Andersen", "Solitude", "1:31", R.drawable.solitude));
        mSongs.add(new Song("Solitude", "Ryan Andersen", "Solitude", "3:26", R.drawable.solitude));
        mSongs.add(new Song("Awake", "Shaolin Dub", "The Urban Chronicle", "3:00", R.drawable.theurbanchronicle));
        mSongs.add(new Song("Concrete Worries", "Shaolin Dub", "The Urban Chronicle", "3:27", R.drawable.theurbanchronicle));
        mSongs.add(new Song("Islands", "SPCZ", "Holism", "3:59", R.drawable.holism));
        mSongs.add(new Song("Quarks", "SPCZ", "Holism", "4:53", R.drawable.holism));
        mSongs.add(new Song("Calva Song", "Wankers United", "Polygon Soup", "4:06", R.drawable.polygonsoup));
    }

    /**
     * Extract the Albums and all the Songs contained in those Albums.
     * We do it this way, because as soon as we add a Song in the Album's ArrayList
     * the Album Object changes and we loose reference.
     */
    private void extractAlbums() {
        ArrayList<String> existingAlbums = new ArrayList<>();
        for (int i = 0; i < mSongs.size(); i++) {
            Song song = mSongs.get(i);
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

    /**
     * Extract the Artists and all the Songs associated with those Artists.
     * We do it this way, because as soon as we add a Song in the Artist's ArrayList
     * the Artist Object changes and we loose reference.
     */
    private void extractArtists() {
        ArrayList<String> existingArtists = new ArrayList<>();
        for (int i = 0; i < mSongs.size(); i++) {
            Song song = mSongs.get(i);
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

    /** @return Returns the total number of Albums for the specified Artist. */
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

    /** @return Returns the full list of Songs. */
    public ArrayList<Song> getSongs() {
        return mSongs;
    }

    /** @return Returns the full list of Artists. */
    public ArrayList<Artist> getArtists() {
        return mArtists;
    }

    /** @return Returns the full list of Albums. */
    public ArrayList<Album> getAlbums() {
        return mAlbums;
    }

}
