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
 * ArtistFragment is the Class that displays the Artists Tab in the Main Activity.
 */
public class ArtistsFragment extends Fragment {

    /** Empty ArtistsFragment Constructor. */
    public ArtistsFragment() {}

    /**
     * Overrides the onCreateView() method to assemble and display the Artists List.
     * @param inflater The layout inflater.
     * @param container The container view.
     * @param savedInstanceState The Bundle for the Saved Instance State.
     * @return Returns the assembled Artists List to display in the Artists Tab.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set the Root View and attach it to the Container
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get the Data for the Artists List
        Data data = Data.getInstance();
        final ArrayList<Artist> artists = data.getArtists();

        // Populate the Artists ListView
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        ArtistAdapter adapter = new ArtistAdapter(getActivity(), artists);
        listView.setAdapter(adapter);

        // Set the OnItemClickListener() to handle the item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the current Artist
                Artist thisArtist = artists.get(position);

                // Attach the intent to open the List Activity for the current Artist
                Intent listActivity = new Intent(getContext(), ListActivity.class);
                listActivity.putExtra("artist_data", thisArtist);
                startActivity(listActivity);

            }
        });

        // Return the fully assembled Artists ListView
        return rootView;
    }
}
