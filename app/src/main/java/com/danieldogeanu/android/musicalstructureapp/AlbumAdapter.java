package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        final Album currentAlbum = getItem(position);

        Utils.setTextToView(listItemView, R.id.albumTitle, currentAlbum.getAlbumName());
        Utils.setTextToView(listItemView, R.id.albumArtist, currentAlbum.getAlbumArtist());

        Utils.addDetailsButtonIntent(listItemView, R.id.albumListBtn, ListActivity.class, "album_data", currentAlbum);

        return listItemView;
    }
}
