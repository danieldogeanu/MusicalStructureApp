package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Utils.deactivateMenuButton(ListActivity.this);
        Utils.activateBackButton(ListActivity.this);

        ListView listView = (ListView) findViewById(R.id.activityListView);

        // Get Data
        Artist thisArtist = (Artist) getIntent().getSerializableExtra("artist_data");
        Album thisAlbum = (Album) getIntent().getSerializableExtra("album_data");

        if (thisArtist != null) {
            ArrayList<Song> songsByThisArtist = thisArtist.getSongsByArtist();
            SongAdapter adapter = new SongAdapter(ListActivity.this, songsByThisArtist, listView);
            listView.setAdapter(adapter);
        }

        if (thisAlbum != null) {
            ArrayList<Song> songsOnThisAlbum = thisAlbum.getSongsInAlbum();
            SongAdapter adapter = new SongAdapter(ListActivity.this, songsOnThisAlbum, listView);
            listView.setAdapter(adapter);
        }

    }
}
