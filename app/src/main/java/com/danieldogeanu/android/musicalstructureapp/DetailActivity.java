package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Class that initializes the Detail Activity screen.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Deactivate the Menu Button and Activate the Back Button
        Utils.deactivateMenuButton(DetailActivity.this);
        Utils.activateBackButton(DetailActivity.this);

        // Set Activity Header Title
        Utils.setTextToView(DetailActivity.this, R.id.headerTitle, getText(R.string.detail_title));

        // Get Favorites and Song Data
        final Favorites favorites = Favorites.getInstance();
        final Song thisSong = (Song) getIntent().getSerializableExtra("song_data");

        if (thisSong != null) {

            // Set Song Title and Song Artist
            Utils.setTextToView(DetailActivity.this, R.id.songTitleDetail, thisSong.getSongTitle());
            Utils.setTextToView(DetailActivity.this, R.id.songArtistDetail, thisSong.getSongArtist());

            // Set the Song Album Art
            ImageView songAlbumArtView = (ImageView) findViewById(R.id.songAlbumArt);
            if (thisSong.hasAlbumArt())  {
                songAlbumArtView.setImageResource(thisSong.getSongAlbumArt());
            }

            // Set Favorites Button State
            final ImageButton favoritesButton = (ImageButton) findViewById(R.id.addSongToFavorite);
            if (favorites.isFavorite(thisSong)) favoritesButton.setActivated(true);
            favoritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Add or Remove the Song to/from Favorites
                    if (!favorites.isFavorite(thisSong) && !favoritesButton.isActivated()) {
                        favorites.addSongToFavorites(thisSong);
                        favoritesButton.setActivated(true);
                    } else {
                        favorites.removeSongFromFavorites(thisSong);
                        favoritesButton.setActivated(false);
                    }

                }
            });

        }

    }
}
