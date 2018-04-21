package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * AlbumAdapter is a custom ArrayAdapter for the Album objects.
 * It's used to build the list of items to display in the Albums Tab.
 */
public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * AlbumAdapter Constructor. Accepts 2 parameters.
     * @param context The Activity on which this adapter will run.
     * @param albums The ArrayList with all the albums.
     */
    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    /**
     * Overrides the getView() method to display a custom layout for each item in the ListView.
     * @param position The position in the ListView.
     * @param convertView The view for the Item in the ListView.
     * @param parent The parent view.
     * @return Returns the assembled Item to display in the ListView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get or inflate the Album Item View
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        // Get current Album object from the ArrayList
        final Album currentAlbum = getItem(position);

        // Set the Album Title and Album Artist
        Utils.setTextToView(listItemView, R.id.albumTitle, currentAlbum.getAlbumName());
        Utils.setTextToView(listItemView, R.id.albumArtist, currentAlbum.getAlbumArtist());

        // Attach intent to the Album List Button to open the List Activity
        Utils.addDetailsButtonIntent(listItemView, R.id.albumListBtn, ListActivity.class, "album_data", currentAlbum);

        // Return the fully assembled Album Item
        return listItemView;
    }
}
