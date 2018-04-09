package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public static final String LOG_TAG = ArtistAdapter.class.getSimpleName();

    private ListView mArtistListView;

    public ArtistAdapter(Activity context, ArrayList<Artist> artists, ListView view) {
        super(context, 0, artists);
        mArtistListView = view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.artist_item, parent, false);
        }

        final Artist currentArtist = getItem(position);

        Utils.setTextToView(listItemView, R.id.artistName, currentArtist.getArtistName());

        String artistSongsText = listItemView.getResources().getQuantityString(R.plurals.number_of_songs, currentArtist.getArtistSongsCount(), currentArtist.getArtistSongsCount());
        String artistAlbumText = listItemView.getResources().getQuantityString(R.plurals.number_of_albums, currentArtist.getArtistAlbumsCount(), currentArtist.getArtistAlbumsCount());
        String artistDataText = listItemView.getResources().getString(R.string.artist_data, artistSongsText, artistAlbumText);
        Utils.setTextToView(listItemView, R.id.artistData, artistDataText);

        ImageButton artistListBtn = (ImageButton) listItemView.findViewById(R.id.artistListBtn);
        artistListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(getContext(), ListActivity.class);
                thisIntent.putExtra("artist_data", currentArtist);
                getContext().startActivity(thisIntent);
            }
        });

        return listItemView;
    }
}
