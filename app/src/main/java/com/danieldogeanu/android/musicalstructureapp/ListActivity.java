package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
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
        SongAdapter adapter = null;

        // Get Data
        Artist thisArtist = (Artist) getIntent().getSerializableExtra("artist_data");
        Album thisAlbum = (Album) getIntent().getSerializableExtra("album_data");

        if (thisArtist != null) {
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.artist_list_title));

            ArrayList<Song> songsByThisArtist = thisArtist.getSongsByArtist();
            adapter = new SongAdapter(ListActivity.this, songsByThisArtist);
            listView.setAdapter(adapter);
        }

        if (thisAlbum != null) {
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.album_list_title));

            ArrayList<Song> songsOnThisAlbum = thisAlbum.getSongsInAlbum();
            adapter = new SongAdapter(ListActivity.this, songsOnThisAlbum);
            listView.setAdapter(adapter);
        }

        if (adapter != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ImageView songPlayingIcon = (ImageView) view.findViewById(R.id.songPlaying);
                    Utils.toggleVisibility(songPlayingIcon);

                }
            });
        }

    }
}
