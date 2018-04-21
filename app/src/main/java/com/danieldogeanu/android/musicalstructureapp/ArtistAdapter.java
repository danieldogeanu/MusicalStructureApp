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
 * ArtistAdapter is a custom ArrayAdapter for the Artist objects.
 * It's used to build the list of items to display in the Artists Tab.
 */
public class ArtistAdapter extends ArrayAdapter<Artist> {

    /**
     * ArtistAdapter Constructor. Accepts 2 parameters.
     * @param context The Activity on which this adapter will run.
     * @param artists The ArrayList with all the artists.
     */
    public ArtistAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
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

        // Get or inflate the Artist Item View
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.artist_item, parent, false);
        }

        // Get current Artist object from the ArrayList
        final Artist currentArtist = getItem(position);

        // Set the Artist Name
        Utils.setTextToView(listItemView, R.id.artistName, currentArtist.getArtistName());

        // Set the Number of Songs and Albums by this Artist
        String artistSongsText = listItemView.getResources().getQuantityString(R.plurals.number_of_songs, currentArtist.getArtistSongsCount(), currentArtist.getArtistSongsCount());
        String artistAlbumText = listItemView.getResources().getQuantityString(R.plurals.number_of_albums, currentArtist.getArtistAlbumsCount(), currentArtist.getArtistAlbumsCount());
        String artistDataText = listItemView.getResources().getString(R.string.artist_data, artistSongsText, artistAlbumText);
        Utils.setTextToView(listItemView, R.id.artistData, artistDataText);

        // Attach intent to the Artist List Button to open the List Activity
        Utils.addDetailsButtonIntent(listItemView, R.id.artistListBtn, ListActivity.class, "artist_data", currentArtist);

        // Return the fully assembled Artist Item
        return listItemView;
    }
}
