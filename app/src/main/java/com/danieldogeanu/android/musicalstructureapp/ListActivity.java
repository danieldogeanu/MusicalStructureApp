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

        // Get Artist Object
        Artist thisArtist = (Artist) getIntent().getSerializableExtra("artist_data");

        ArrayList<Song> songsByThisArtist = thisArtist.getSongsByArtist();

        ListView listView = (ListView) findViewById(R.id.activityListView);
        SongAdapter adapter = new SongAdapter(ListActivity.this, songsByThisArtist, listView);
        listView.setAdapter(adapter);
    }
}
