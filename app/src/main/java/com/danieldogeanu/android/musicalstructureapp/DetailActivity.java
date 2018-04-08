package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Song thisSong = (Song) getIntent().getSerializableExtra("song_data");

        if (thisSong != null) {
            TextView songTitle = (TextView) findViewById(R.id.songTitleDetail);
            songTitle.setText(thisSong.getSongTitle());

            TextView songArtist = (TextView) findViewById(R.id.songArtistDetail);
            songArtist.setText(thisSong.getSongArtist());
        }

    }
}
