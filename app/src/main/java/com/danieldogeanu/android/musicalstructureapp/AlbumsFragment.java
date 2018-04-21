package com.danieldogeanu.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * AlbumFragment is the Class that displays the Albums Tab in the Main Activity.
 */
public class AlbumsFragment extends Fragment {

    /** Empty AlbumsFragment Constructor. */
    public AlbumsFragment() {}

    /**
     * Overrides the onCreateView() method to assemble and display the Albums List.
     * @param inflater The layout inflater.
     * @param container The container view.
     * @param savedInstanceState The Bundle for the Saved Instance State.
     * @return Returns the assembled Albums List to display in the Albums Tab.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set the Root View and attach it to the Container
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get the Data for the Albums List
        Data data = Data.getInstance();
        final ArrayList<Album> albums = data.getAlbums();

        // Populate the Albums ListView
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        AlbumAdapter adapter = new AlbumAdapter(getActivity(), albums);
        listView.setAdapter(adapter);

        // Set the OnItemClickListener() to handle the item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the current Album
                Album thisAlbum = albums.get(position);

                // Attach the intent to open the List Activity for the current Album
                Intent listActivity = new Intent(getContext(), ListActivity.class);
                listActivity.putExtra("album_data", thisAlbum);
                startActivity(listActivity);

            }
        });

        // Return the fully assembled Albums ListView
        return rootView;
    }
}
