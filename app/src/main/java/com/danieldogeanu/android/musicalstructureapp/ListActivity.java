package com.danieldogeanu.android.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageButton menuButton = findViewById(R.id.menuBtn);
        menuButton.setVisibility(View.GONE);

        ImageButton backButton = findViewById(R.id.backBtn);
        backButton.setVisibility(View.VISIBLE);

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
