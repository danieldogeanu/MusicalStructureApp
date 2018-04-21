package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
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

        Utils.addDetailsButtonIntent(listItemView, R.id.artistListBtn, ListActivity.class, "artist_data", currentArtist);

        return listItemView;
    }
}
