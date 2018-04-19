package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
        final MediaState mediaState = MediaState.getInstance();

        if (thisArtist != null) {
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.artist_list_title));

            final ArrayList<Song> songsByThisArtist = thisArtist.getSongsByArtist();
            SongAdapter adapter = new SongAdapter(ListActivity.this, songsByThisArtist, mediaState);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Song song = songsByThisArtist.get(position);
                    mediaState.setPlayingSong(song);

                    Utils.togglePlayingIcon(view);

                }
            });
        }

        if (thisAlbum != null) {
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.album_list_title));

            final ArrayList<Song> songsOnThisAlbum = thisAlbum.getSongsInAlbum();
            SongAdapter adapter = new SongAdapter(ListActivity.this, songsOnThisAlbum, mediaState);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Song song = songsOnThisAlbum.get(position);
                    mediaState.setPlayingSong(song);

                    Utils.togglePlayingIcon(view);

                }
            });
        }

    }
}
