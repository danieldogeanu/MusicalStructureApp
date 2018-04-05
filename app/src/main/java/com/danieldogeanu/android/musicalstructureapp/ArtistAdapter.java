package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        Artist currentArtist = getItem(position);

        TextView artistName = (TextView) listItemView.findViewById(R.id.artistName);
        artistName.setText(currentArtist.getArtistName());

        TextView artistData = (TextView) listItemView.findViewById(R.id.artistData);
        String artistSongsText = listItemView.getResources().getQuantityString(R.plurals.number_of_songs, currentArtist.getArtistSongsCount(), currentArtist.getArtistSongsCount());
        String artistAlbumText = listItemView.getResources().getQuantityString(R.plurals.number_of_albums, currentArtist.getArtistAlbumsCount(), currentArtist.getArtistAlbumsCount());
        String artistDataText = listItemView.getResources().getString(R.string.artist_data, artistSongsText, artistAlbumText);
        artistData.setText(artistDataText);

        // TODO: Add a way to open Artist List activity.

        return listItemView;
    }
}
