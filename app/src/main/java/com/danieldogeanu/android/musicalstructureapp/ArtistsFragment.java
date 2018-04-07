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

public class ArtistsFragment extends Fragment {

    public ArtistsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        Data data = new Data();
        final ArrayList<Artist> artists = data.getArtists();

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        ArtistAdapter adapter = new ArtistAdapter(getActivity(), artists, listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Artist thisArtist = artists.get(position);

                Intent listActivity = new Intent(getContext(), ListActivity.class);
                listActivity.putExtra("artist_data", thisArtist);
                startActivity(listActivity);

            }
        });

        return rootView;
    }
}
