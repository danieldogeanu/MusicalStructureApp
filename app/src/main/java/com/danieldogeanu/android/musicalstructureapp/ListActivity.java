package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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

        // Get the Data and MediaState
        Artist thisArtist = (Artist) getIntent().getSerializableExtra("artist_data");
        Album thisAlbum = (Album) getIntent().getSerializableExtra("album_data");
        final MediaState mediaState = MediaState.getInstance();

        if (thisArtist != null) {
            // Set List Activity Title
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.artist_list_title));

            // Populate the ListView with Songs by current Artist
            final ArrayList<Song> songsByThisArtist = thisArtist.getSongsByArtist();
            final SongAdapter adapter = new SongAdapter(ListActivity.this, songsByThisArtist, mediaState);
            listView.setAdapter(adapter);

            // Set the OnItemClickListener() to handle the item clicks
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    // Get the current Song
                    Song song = songsByThisArtist.get(position);

                    // Toggle the currently playing Song and the Song Playing Icon
                    mediaState.togglePlayingSong(song, view);

                }
            });
        }

        if (thisAlbum != null) {
            // Set List Activity Title
            Utils.setTextToView(ListActivity.this, R.id.headerTitle, getText(R.string.album_list_title));

            // Populate the ListView with Songs in the current Album
            final ArrayList<Song> songsOnThisAlbum = thisAlbum.getSongsInAlbum();
            final SongAdapter adapter = new SongAdapter(ListActivity.this, songsOnThisAlbum, mediaState);
            listView.setAdapter(adapter);

            // Set the OnItemClickListener() to handle the item clicks
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    // Get the current Song
                    Song song = songsOnThisAlbum.get(position);

                    // Toggle the currently playing Song and the Song Playing Icon
                    mediaState.togglePlayingSong(song, view);

                }
            });
        }

    }
}
