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

public class AlbumAdapter extends ArrayAdapter<Album> {

    public static final String LOG_TAG = AlbumAdapter.class.getSimpleName();

    private ListView mAlbumListView;

    public AlbumAdapter(Activity context, ArrayList<Album> albums, ListView view) {
        super(context, 0, albums);
        mAlbumListView = view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        Album currentAlbum = getItem(position);

        TextView albumTitle = (TextView) listItemView.findViewById(R.id.albumTitle);
        albumTitle.setText(currentAlbum.getAlbumName());

        TextView albumArtist = (TextView) listItemView.findViewById(R.id.albumArtist);
        albumArtist.setText(currentAlbum.getAlbumArtist());

        // TODO: Add a way to open Album List activity.

        return listItemView;
    }
}
