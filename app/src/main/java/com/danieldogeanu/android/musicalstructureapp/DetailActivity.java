package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Utils.deactivateMenuButton(DetailActivity.this);
        Utils.activateBackButton(DetailActivity.this);

        TextView headerTitle = (TextView) findViewById(R.id.headerTitle);
        headerTitle.setText(getText(R.string.detail_title));

        // Get Song Data
        final Favorites favorites = Favorites.getInstance();
        final Song thisSong = (Song) getIntent().getSerializableExtra("song_data");

        if (thisSong != null) {
            TextView songTitle = (TextView) findViewById(R.id.songTitleDetail);
            songTitle.setText(thisSong.getSongTitle());

            TextView songArtist = (TextView) findViewById(R.id.songArtistDetail);
            songArtist.setText(thisSong.getSongArtist());

            final ImageButton favoritesButton = (ImageButton) findViewById(R.id.addSongToFavorite);
            if (favorites.isFavorite(thisSong)) favoritesButton.setActivated(true);
            favoritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

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
