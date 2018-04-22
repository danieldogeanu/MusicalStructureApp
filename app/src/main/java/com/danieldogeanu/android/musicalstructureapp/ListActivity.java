package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Class that initializes the List Activity screen.
 */
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Deactivate the Menu Button and Activate the Back Button
        Utils.deactivateMenuButton(ListActivity.this);
        Utils.activateBackButton(ListActivity.this);

        // Get the ListView
        ListView listView = (ListView) findViewById(R.id.activityListView);

        // Get the Data
        Artist thisArtist = (Artist) getIntent().getSerializableExtra("artist_data");
        Album thisAlbum = (Album) getIntent().getSerializableExtra("album_data");

        if (thisArtist != null) {
            // Set List Activity Title
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.artist_list_title));

            // Populate the ListView with Songs by current Artist
            ArrayList<Song> songsByThisArtist = thisArtist.getSongsByArtist();
            SongAdapter adapter = new SongAdapter(ListActivity.this, songsByThisArtist);
            listView.setAdapter(adapter);
        }

        if (thisAlbum != null) {
            // Set List Activity Title
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.album_list_title));

            // Populate the ListView with Songs in the current Album
            ArrayList<Song> songsOnThisAlbum = thisAlbum.getSongsInAlbum();
            SongAdapter adapter = new SongAdapter(ListActivity.this, songsOnThisAlbum);
            listView.setAdapter(adapter);
        }

    }
}
